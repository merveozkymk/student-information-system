package Nyp_Proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonelLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelLogin frame = new PersonelLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PersonelLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bilgilerinizi girin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(98, 74, 139, 24);
		contentPane.add(lblNewLabel);
		
		JLabel idLabel = new JLabel("Personel Id:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(124, 127, 86, 24);
		contentPane.add(idLabel);
		
		JLabel sifreLabel = new JLabel("Şifre:");
		sifreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sifreLabel.setBounds(124, 180, 86, 24);
		contentPane.add(sifreLabel);
		
		textField = new JTextField();
		textField.setBounds(220, 125, 126, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 178, 126, 33);
		contentPane.add(textField_1);
		
		JButton girisButton = new JButton("Giriş");
		girisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelSistemi personnelSistemi = new PersonelSistemi();
				personnelSistemi.setVisible(true);
				dispose(); 
			}
		});
		girisButton.setBounds(344, 245, 126, 33);
		contentPane.add(girisButton);
		
		JLabel lblNewLabel_1 = new JLabel("Personel Girişi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(248, 11, 149, 24);
		contentPane.add(lblNewLabel_1);
	}
}

