package Nyp_Proje;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AkademisyenLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextField textFieldPassword;
    private AkademisyenDatabase akademisyenDatabase = new AkademisyenDatabase();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AkademisyenLogin frame = new AkademisyenLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AkademisyenLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Akademisyen Girişi");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(220, 11, 200, 24);
        contentPane.add(lblTitle);

        JLabel lblInstruction = new JLabel("Bilgilerinizi girin:");
        lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblInstruction.setBounds(98, 74, 139, 24);
        contentPane.add(lblInstruction);

        JLabel lblId = new JLabel("Akademisyen ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(124, 127, 120, 24);
        contentPane.add(lblId);

        JLabel lblPassword = new JLabel("Şifre:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(124, 180, 86, 24);
        contentPane.add(lblPassword);

        textFieldId = new JTextField();
        textFieldId.setBounds(250, 125, 126, 33);
        contentPane.add(textFieldId);
        textFieldId.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(250, 178, 126, 33);
        contentPane.add(textFieldPassword);

        JButton btnLogin = new JButton("Giriş");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String akademisyenId = textFieldId.getText();
                String sifre = textFieldPassword.getText();

                if (akademisyenDatabase.login(akademisyenId, sifre)) {
                    JOptionPane.showMessageDialog(contentPane, "Giriş Başarılı!");

                    Akademisyen loggedInAkademisyen = akademisyenDatabase.getAkademisyenById(akademisyenId);

                    AkademisyenSistemi akademisyenSistemi = new AkademisyenSistemi(loggedInAkademisyen);
                    akademisyenSistemi.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Giriş Başarısız! Lütfen bilgilerinizi kontrol edin.",
                            "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(339, 247, 126, 33);
        contentPane.add(btnLogin);
    }
}

