package Nyp_Proje;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PersonelSistemi extends JFrame {

    Studentdatabase studentDatabase = new Studentdatabase(); 

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPanel; 
    private JTextField ogrisimfield;
    private JTextField ogrnofield;
    private JTextField ogrSifreField;

    private JTextField akdisimfield;

    private JTextField akdnofield;

    private JTextField akdSifreField;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PersonelSistemi frame = new PersonelSistemi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PersonelSistemi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Baslik = new JLabel("Personel Sistemi");
        Baslik.setFont(new Font("Tahoma", Font.BOLD, 16));
        Baslik.setBounds(230, 11, 144, 40);
        contentPane.add(Baslik);

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton OgrenciKayitRadio = new JRadioButton("Öğrenci Kayıt");
        OgrenciKayitRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        OgrenciKayitRadio.setBounds(35, 98, 141, 23);
        contentPane.add(OgrenciKayitRadio);
        buttonGroup.add(OgrenciKayitRadio);

        JRadioButton AkademisyenKayitRadio = new JRadioButton("Akademisyen Kayıt");
        AkademisyenKayitRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        AkademisyenKayitRadio.setBounds(35, 134, 141, 23);
        contentPane.add(AkademisyenKayitRadio);
        buttonGroup.add(AkademisyenKayitRadio);

        JRadioButton rdbtnOgrenciListesi = new JRadioButton("Öğrenci Listesi");
        rdbtnOgrenciListesi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnOgrenciListesi.setBounds(35, 172, 141, 23);
        contentPane.add(rdbtnOgrenciListesi);
        buttonGroup.add(rdbtnOgrenciListesi);

        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBounds(200, 60, 340, 300);
        contentPane.add(contentPanel);

        JPanel ogrenciPanel = new JPanel();
        ogrenciPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        ogrenciPanel.setLayout(null);
        JLabel label = new JLabel("Öğrenci Kayıt Formu");
        label.setBounds(124, 5, 133, 24);
        ogrenciPanel.add(label);
        contentPanel.add(ogrenciPanel, "Ogrenci");

        JLabel ogrisimLabel = new JLabel("Öğrenci İsim: ");
        ogrisimLabel.setBounds(37, 55, 95, 24);
        ogrenciPanel.add(ogrisimLabel);

        JLabel ogrSoyisimLabel = new JLabel("Şifre:");
        ogrSoyisimLabel.setBounds(37, 170, 95, 24);
        ogrenciPanel.add(ogrSoyisimLabel);

        JLabel ogrNoLabel = new JLabel("Öğrenci no:");
        ogrNoLabel.setBounds(37, 114, 95, 24);
        ogrenciPanel.add(ogrNoLabel);

        ogrisimfield = new JTextField();
        ogrisimfield.setBounds(134, 50, 115, 35);
        ogrenciPanel.add(ogrisimfield);
        ogrisimfield.setColumns(10);

        ogrnofield = new JTextField();
        ogrnofield.setColumns(10);
        ogrnofield.setBounds(134, 109, 115, 35);
        ogrenciPanel.add(ogrnofield);

        ogrSifreField = new JTextField();
        ogrSifreField.setColumns(10);
        ogrSifreField.setBounds(134, 165, 115, 35);
        ogrenciPanel.add(ogrSifreField);

        JButton ogrKayitButton = new JButton("Kaydet");
        ogrKayitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isim = ogrisimfield.getText();
                String id = ogrnofield.getText();
                String sifre = ogrSifreField.getText();

                if (!isim.isEmpty() && !id.isEmpty() && !sifre.isEmpty()) {
                    Student newStudent = new Student(id, isim, sifre);
                    studentDatabase.addStudent(newStudent);
                    System.out.println("Öğrenci başarıyla eklendi: " + newStudent);
                    javax.swing.JOptionPane.showMessageDialog(null, "Öğrenci başarıyla kaydedildi!",
                            "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    ogrisimfield.setText("");
                    ogrnofield.setText("");
                    ogrSifreField.setText("");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(contentPane, "Lütfen tüm alanları doldurun!",
                            "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ogrKayitButton.setBounds(206, 235, 103, 35);
        ogrenciPanel.add(ogrKayitButton);
        
        JPanel akademisyenPanel = new JPanel();
		akademisyenPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		akademisyenPanel.setLayout(null);
		JLabel label1 = new JLabel("Akademisyen Kayıt Formu");
		label1.setBounds(124, 5, 160, 24);
		akademisyenPanel.add(label1);
		contentPanel.add(akademisyenPanel, "Akademisyen");
		
		JLabel AkdisimLabel = new JLabel("Akademisyen İsim: ");
		AkdisimLabel.setBounds(17, 55, 131, 24);
		akademisyenPanel.add(AkdisimLabel);
		
		JLabel AkdSifreLabel = new JLabel("Şifre:");
		AkdSifreLabel.setBounds(17, 183, 95, 24);
		akademisyenPanel.add(AkdSifreLabel);
		
		JLabel AkdNoLabel = new JLabel("Akademisyen no:");
		AkdNoLabel.setBounds(17, 95, 104, 24);
		akademisyenPanel.add(AkdNoLabel);
		
		akdisimfield = new JTextField();
		akdisimfield.setBounds(134, 50, 115, 35);
		akademisyenPanel.add(akdisimfield);
		akdisimfield.setColumns(10);
		
		akdnofield = new JTextField();
		akdnofield.setColumns(10);
		akdnofield.setBounds(134, 90, 115, 35);
		akademisyenPanel.add(akdnofield);
		
		akdSifreField = new JTextField();
		akdSifreField.setColumns(10);
		akdSifreField.setBounds(134, 178, 115, 35);
		akademisyenPanel.add(akdSifreField);
		
		JButton akdKayitButton = new JButton("Kaydet");
		akdKayitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String isim = akdisimfield.getText();
		        String no = akdnofield.getText();
		        String sifre = akdSifreField.getText();
		        String bolum = textField.getText(); 
		        if (isim.isEmpty() || no.isEmpty() || sifre.isEmpty() || bolum.isEmpty()) {
		            JOptionPane.showMessageDialog(akademisyenPanel, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        Akademisyen yeniAkademisyen = new Akademisyen(no, isim, bolum, sifre);

		        AkademisyenDatabase akademisyenDatabase = new AkademisyenDatabase(); 
		        akademisyenDatabase.akademisyenEkle(yeniAkademisyen);

		        JOptionPane.showMessageDialog(akademisyenPanel, "Akademisyen başarıyla eklendi!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);

		        akdisimfield.setText("");
		        akdnofield.setText("");
		        akdSifreField.setText("");
		        textField.setText("");
		    }
		});
		akdKayitButton.setBounds(206, 235, 103, 35);
		akademisyenPanel.add(akdKayitButton);
		
		JLabel AkdNoLabel_1 = new JLabel("Bölüm:");
		AkdNoLabel_1.setBounds(17, 137, 104, 24);
		akademisyenPanel.add(AkdNoLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 132, 115, 35);
		akademisyenPanel.add(textField);

        JPanel ogrenciListesiPanel = new JPanel();
        ogrenciListesiPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        ogrenciListesiPanel.setLayout(null);
        JLabel listLabel = new JLabel("Öğrenci Listesi");
        listLabel.setBounds(124, 5, 133, 24);
        ogrenciListesiPanel.add(listLabel);

        JTextArea ogrenciListesiArea = new JTextArea();
        ogrenciListesiArea.setBounds(10, 40, 320, 250);
        ogrenciListesiArea.setEditable(false);
        ogrenciListesiPanel.add(ogrenciListesiArea);
        contentPanel.add(ogrenciListesiPanel, "OgrenciListesi");
        
        JButton btnGeri = new JButton("Çıkış");
        btnGeri.setBounds(437, 381, 103, 35);
        contentPane.add(btnGeri);
        btnGeri.addActionListener(e -> {
        	 System.exit(0);  
        });

        OgrenciKayitRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "Ogrenci");
            }
        });

        AkademisyenKayitRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "Akademisyen");
            }
        });

        rdbtnOgrenciListesi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "OgrenciListesi");

                ogrenciListesiArea.setText(""); 
                for (Student student : Studentdatabase.listAllStudents()) {
                    ogrenciListesiArea.append("İsim: " + student.getName() + ", Numara: " + student.getId() + "\n");
                }
            }
        });
    }
}