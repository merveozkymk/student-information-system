package Nyp_Proje;

import java.util.HashMap;

public class AkademisyenDatabase {
    private HashMap<String, Akademisyen> akademisyenler; 
    
    public AkademisyenDatabase() {
        akademisyenler = new HashMap<>();
        ornekVeriEkle();
    }

   
    public void akademisyenEkle(Akademisyen akademisyen) {
        if (akademisyenler.containsKey(akademisyen.getId())) {
            System.out.println("Bu ID'ye sahip bir akademisyen zaten mevcut: " + akademisyen.getId());
        } else {
            akademisyenler.put(akademisyen.getId(), akademisyen);
            System.out.println("Akademisyen başarıyla eklendi: " + akademisyen.getName());
        }
    }
    public boolean login(String id, String password) {
        Akademisyen akademisyen = akademisyenler.get(id);
        return akademisyen != null && akademisyen.getPassword().equals(password);
    }
    public Akademisyen getAkademisyenById(String id) {
        return akademisyenler.get(id);
    }


    public void tumAkademisyenleriListele() {
        if (akademisyenler.isEmpty()) {
            System.out.println("Hiçbir akademisyen kayıtlı değil.");
        } else {
            System.out.println("Tüm Akademisyenler:");
            for (Akademisyen akademisyen : akademisyenler.values()) {
                System.out.println(akademisyen);
            }
        }
    }

    public int akademisyenSayisi() {
        return akademisyenler.size();
    }

    private void ornekVeriEkle() {
        Akademisyen akademisyen1 = new Akademisyen("A01", "Ahmet Yılmaz", "Bilgisayar Mühendisliği", "1234");
        Akademisyen akademisyen2 = new Akademisyen("A02", "Mehmet Kaya", "Elektrik-Elektronik Mühendisliği", "5678");
        Akademisyen akademisyen3 = new Akademisyen("A03", "Ayşe Demir", "Makine Mühendisliği", "91011");

        akademisyenler.put(akademisyen1.getId(), akademisyen1);
        akademisyenler.put(akademisyen2.getId(), akademisyen2);
        akademisyenler.put(akademisyen3.getId(), akademisyen3);
    }
}

