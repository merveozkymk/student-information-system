package Nyp_Proje;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import Nyp_Proje.Student;

public class OgrenciSistemi extends JFrame {

    private static final long serialVersionUID = 1L;
    private Student loggedInStudent;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public OgrenciSistemi(Student student) {
        this.loggedInStudent = student;  

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Öğrenci Sistemi");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(235, 11, 150, 25);
        contentPane.add(lblNewLabel);

        JRadioButton rdbtnProfilBilgileri = new JRadioButton("Profil Bilgileri");
        buttonGroup.add(rdbtnProfilBilgileri);
        rdbtnProfilBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnProfilBilgileri.setBounds(43, 76, 111, 23);
        contentPane.add(rdbtnProfilBilgileri);
        
        JRadioButton rdbtnDersEkleme = new JRadioButton("Ders Ekleme");
        buttonGroup.add(rdbtnDersEkleme);
        rdbtnDersEkleme.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnDersEkleme.setBounds(43, 127, 150, 23);
        contentPane.add(rdbtnDersEkleme);

        JRadioButton rdbtnDersGoruntuleme = new JRadioButton("Ders Görüntüleme");
        buttonGroup.add(rdbtnDersGoruntuleme);
        rdbtnDersGoruntuleme.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnDersGoruntuleme.setBounds(43, 178, 150, 23);
        contentPane.add(rdbtnDersGoruntuleme);

        JRadioButton rdbtnSifreDegistirme = new JRadioButton("Şifre Değiştirme");
        buttonGroup.add(rdbtnSifreDegistirme);
        rdbtnSifreDegistirme.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnSifreDegistirme.setBounds(43, 229, 125, 23);
        contentPane.add(rdbtnSifreDegistirme);

        JPanel ProfilPanel = new JPanel();
        ProfilPanel.setBounds(233, 73, 311, 269);
        ProfilPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        contentPane.add(ProfilPanel);
        ProfilPanel.setLayout(null);
        
        JPanel SifrePanel = new JPanel();
        SifrePanel.setBounds(233, 73, 311, 269);
        SifrePanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        contentPane.add(SifrePanel);
        SifrePanel.setLayout(null);
        SifrePanel.setVisible(false); 

        JLabel lblStudentName = new JLabel("Öğrenci Adı: " + loggedInStudent.getName());
        lblStudentName.setBounds(25, 32, 200, 20);
        ProfilPanel.add(lblStudentName);
        lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblStudentId = new JLabel("Öğrenci No: " + loggedInStudent.getId());
        lblStudentId.setBounds(25, 63, 200, 25);
        ProfilPanel.add(lblStudentId);
        lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JLabel lblStudentSifre = new JLabel("Öğrenci Sifre: " + loggedInStudent.getPassword());
        lblStudentSifre.setBounds(25, 94, 200, 25);
        ProfilPanel.add(lblStudentSifre);
        lblStudentSifre.setFont(new Font("Tahoma", Font.PLAIN, 13));
   
        JPanel dersEklemePanel = new JPanel();
        dersEklemePanel.setBounds(233, 73, 311, 269);
        dersEklemePanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        contentPane.add(dersEklemePanel);
        dersEklemePanel.setLayout(null);
        dersEklemePanel.setVisible(false); 

        JLabel lblDersSecimi = new JLabel("Ders Seçimi:");
        lblDersSecimi.setBounds(25, 32, 100, 25);
        dersEklemePanel.add(lblDersSecimi);

        String[] dersler = {"Matematik", "Fizik", "Kimya", "Biyoloji", "Edebiyat"};
        JComboBox<String> comboBoxDersler = new JComboBox<>(dersler);
        comboBoxDersler.setBounds(150, 32, 120, 25);
        dersEklemePanel.add(comboBoxDersler);

        JButton btnDersEkle = new JButton("Ders Ekle");
        btnDersEkle.setBounds(150, 100, 120, 25);
        dersEklemePanel.add(btnDersEkle);

        btnDersEkle.addActionListener(e -> {
            String secilenDers = (String) comboBoxDersler.getSelectedItem();
            Course yeniDers = new Course(secilenDers, "Not Girilmedi");
            loggedInStudent.addCourse(yeniDers);
            JOptionPane.showMessageDialog(this, secilenDers + " Başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        });

        rdbtnDersEkleme.addActionListener(e -> {
            ProfilPanel.setVisible(false);
            SifrePanel.setVisible(false);
            dersEklemePanel.setVisible(true);
        });
    
        JPanel dersGoruntulemePanel = new JPanel();
        dersGoruntulemePanel.setBounds(233, 73, 311, 269);
        dersGoruntulemePanel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        contentPane.add(dersGoruntulemePanel);
        dersGoruntulemePanel.setLayout(new BorderLayout());
        dersGoruntulemePanel.setVisible(false); 

        JTextArea textAreaDersler = new JTextArea();
        textAreaDersler.setEditable(false);
        dersGoruntulemePanel.add(new JScrollPane(textAreaDersler), BorderLayout.CENTER);

        rdbtnDersGoruntuleme.addActionListener(e -> {
            ProfilPanel.setVisible(false);
            SifrePanel.setVisible(false);
            dersEklemePanel.setVisible(false);
            dersGoruntulemePanel.setVisible(true);

            StringBuilder derslerString = new StringBuilder("Mevcut Dersler ve Notlar:\n");
            for (Course course : loggedInStudent.getCourses()) {
                derslerString.append(course.getCourseName()).append(" - Not: ").append(course.getGrade()).append("\n");
            }
            textAreaDersler.setText(derslerString.toString());
        });

        JLabel lblSifreEski = new JLabel("Eski Şifre:");
        lblSifreEski.setBounds(25, 32, 100, 25);
        SifrePanel.add(lblSifreEski);

        JTextField textFieldOldPassword = new JTextField();
        textFieldOldPassword.setBounds(150, 32, 120, 25);
        SifrePanel.add(textFieldOldPassword);

        JLabel lblSifreYeni = new JLabel("Yeni Şifre:");
        lblSifreYeni.setBounds(25, 63, 100, 25);
        SifrePanel.add(lblSifreYeni);

        JTextField textFieldNewPassword = new JTextField();
        textFieldNewPassword.setBounds(150, 63, 120, 25);
        SifrePanel.add(textFieldNewPassword);
        
        JButton btnChangePassword = new JButton("Değiştir");
        btnChangePassword.setBounds(150, 100, 120, 25);
        SifrePanel.add(btnChangePassword);

        btnChangePassword.addActionListener(e -> {
            String oldPassword = textFieldOldPassword.getText();
            String newPassword = textFieldNewPassword.getText();

            if (!oldPassword.equals(loggedInStudent.getPassword())) {
                JOptionPane.showMessageDialog(this, "Eski şifre yanlış!", "Hata", JOptionPane.ERROR_MESSAGE);
            } else if (newPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Yeni şifre boş olamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
            } else {
                loggedInStudent.setPassword(newPassword);
                lblStudentSifre.setText("Öğrenci Sifre: " + newPassword);
                JOptionPane.showMessageDialog(this, "Şifre başarıyla değiştirildi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                textFieldOldPassword.setText("");
                textFieldNewPassword.setText("");
            }
        });
        
        JButton btnExit = new JButton("Çıkış");
        btnExit.setBounds(433, 370, 111, 33);
        contentPane.add(btnExit);
        btnExit.addActionListener(e -> System.exit(0));

        rdbtnProfilBilgileri.addActionListener(e -> {
            ProfilPanel.setVisible(true);
            SifrePanel.setVisible(false);
        });

        rdbtnSifreDegistirme.addActionListener(e -> {
            ProfilPanel.setVisible(false);
            SifrePanel.setVisible(true);
        });

        ProfilPanel.setVisible(true);
        SifrePanel.setVisible(false);
    }
}
