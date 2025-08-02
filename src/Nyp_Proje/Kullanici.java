package Nyp_Proje;

public abstract class Kullanici {
	private String id;
	private String name;
    private String password;

    public Kullanici(String id, String name, String password ) {
    	this.id = id;
        this.name = name;
        this.password = password;
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String yeniSifre) {
        this.password = yeniSifre;
        System.out.println("Şifre başarıyla değiştirildi.");
    }
}

