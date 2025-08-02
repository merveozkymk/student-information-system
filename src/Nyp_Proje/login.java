package Nyp_Proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Nyp_Proje.PersonelLogin;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Baslik = new JLabel("Öğrenci Kontrol Otomasyonu");
		Baslik.setFont(new Font("Tahoma", Font.BOLD, 16));
		Baslik.setBounds(174, 11, 246, 34);
		contentPane.add(Baslik);
		
		JLabel AciklamaLabel = new JLabel("Giriş türünüzü seçin:");
		AciklamaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AciklamaLabel.setBounds(85, 82, 138, 25);
		contentPane.add(AciklamaLabel);
		
		JRadioButton OgrGirisRadio = new JRadioButton("Öğrenci Girişi");
		buttonGroup.add(OgrGirisRadio);
		OgrGirisRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OgrGirisRadio.setBounds(192, 114, 163, 23);
		contentPane.add(OgrGirisRadio);
		
		JRadioButton AkdGirisRadio = new JRadioButton("Akademisyen Girişi");
		buttonGroup.add(AkdGirisRadio);
		AkdGirisRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AkdGirisRadio.setBounds(192, 164, 163, 23);
		contentPane.add(AkdGirisRadio);
		
		JRadioButton PersGirisRadio = new JRadioButton("Personel Girişi");
		buttonGroup.add(PersGirisRadio);
		PersGirisRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PersGirisRadio.setBounds(192, 216, 163, 23);
		contentPane.add(PersGirisRadio);
		
		JButton GirisButton = new JButton("Giriş");
		GirisButton.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
		                if (OgrGirisRadio.isSelected()) {
		                    dispose();
		                    OgrenciLogin ogrencilogin = new OgrenciLogin();
		                    ogrencilogin.setVisible(true);
		                }else if (AkdGirisRadio.isSelected()) {
		                    dispose();
		                    AkademisyenLogin  akademisyensistemi = new AkademisyenLogin();
		                    akademisyensistemi.setVisible(true);
		                }else if (PersGirisRadio.isSelected()) {
		                    dispose();
		                    PersonelLogin  PersonelLogin = new PersonelLogin();
		                    PersonelLogin.setVisible(true);
		                }else {
		                    JOptionPane.showMessageDialog(contentPane, "Lütfen bir seçim yapın!", "Hata", JOptionPane.WARNING_MESSAGE);
		                }
		            }
		});
		GirisButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GirisButton.setBounds(317, 286, 122, 34);
		contentPane.add(GirisButton);
	}

}
