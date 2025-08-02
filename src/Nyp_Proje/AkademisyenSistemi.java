package Nyp_Proje;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AkademisyenSistemi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPanel; 
    private Akademisyen loggedInAkademisyen;

    public AkademisyenSistemi(Akademisyen loggedInAkademisyen) {
        this.loggedInAkademisyen = loggedInAkademisyen; 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Akademisyen Sistemi");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(200, 20, 250, 30);
        contentPane.add(lblTitle);

        JButton btnLogout = new JButton("Çıkış Yap");
        btnLogout.setBounds(418, 303, 132, 30);
        btnLogout.addActionListener(e -> {

            System.exit(0); 
        });
        contentPane.add(btnLogout);

        JRadioButton profilRadio = new JRadioButton("Profil Bilgisi");
        profilRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        profilRadio.setBounds(40, 66, 150, 23);
        contentPane.add(profilRadio);

        JRadioButton notEkleRadio = new JRadioButton("Not Ekle");
        notEkleRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        notEkleRadio.setBounds(40, 98, 150, 23);
        contentPane.add(notEkleRadio);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(profilRadio);
        buttonGroup.add(notEkleRadio);

        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBounds(200, 60, 350, 230);
        contentPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        contentPane.add(contentPanel);

        JPanel profilPanel = new JPanel();
        profilPanel.setLayout(null);

        JLabel lblIsim = new JLabel("İsim: " + loggedInAkademisyen.getName());
        lblIsim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIsim.setBounds(20, 16, 300, 30);
        profilPanel.add(lblIsim);
        
        JLabel lblid = new JLabel("Id: " + loggedInAkademisyen.getId());
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblid.setBounds(20, 45, 300, 30);
        profilPanel.add(lblid);

        JLabel lblBolum = new JLabel("Bölüm: " + loggedInAkademisyen.getDepartment());
        lblBolum.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBolum.setBounds(20, 76, 300, 30);
        profilPanel.add(lblBolum);

        contentPanel.add(profilPanel, "Profil");

        JPanel notEklePanel = new JPanel();
        notEklePanel.setLayout(null);
        
        JLabel lblOgrenci = new JLabel("Öğrenci ID:");
        lblOgrenci.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblOgrenci.setBounds(20, 30, 100, 25);
        notEklePanel.add(lblOgrenci);

        JTextField txtOgrenciId = new JTextField();
        txtOgrenciId.setBounds(130, 30, 180, 25);
        notEklePanel.add(txtOgrenciId);

        JLabel lblDers = new JLabel("Ders Seç:");
        lblDers.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDers.setBounds(20, 70, 100, 25);
        notEklePanel.add(lblDers);

        String[] dersler = {"Matematik", "Fizik", "Kimya", "Biyoloji", "Edebiyat"};
        JComboBox<String> comboBoxDersler = new JComboBox<>(dersler);
        comboBoxDersler.setBounds(130, 70, 180, 25);
        notEklePanel.add(comboBoxDersler);

        JLabel lblNot = new JLabel("Not:");
        lblNot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNot.setBounds(20, 110, 100, 25);
        notEklePanel.add(lblNot);

        JTextField txtNot = new JTextField();
        txtNot.setBounds(130, 110, 180, 25);
        notEklePanel.add(txtNot);

        JButton btnNotGuncelle = new JButton("Not Güncelle");
        btnNotGuncelle.setBounds(130, 150, 180, 25);
        notEklePanel.add(btnNotGuncelle);

        btnNotGuncelle.addActionListener(e -> {
            String ogrenciId = txtOgrenciId.getText();
            String secilenDers = (String) comboBoxDersler.getSelectedItem();
            String yeniNot = txtNot.getText();

            Student student = Studentdatabase.getStudentById(ogrenciId);
            if (student != null) {
                boolean found = false;
                for (Course course : student.getCourses()) {
                    if (course.getCourseName().equals(secilenDers)) {
                        course.setGrade(yeniNot);  
                        JOptionPane.showMessageDialog(contentPane, "Not başarıyla güncellendi!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(contentPane, "Ders bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Öğrenci bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        contentPanel.add(notEklePanel, "NotEkle");      
  ;

        profilRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "Profil");
            }
        });

        notEkleRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "NotEkle");
            }
        });
    }
}
