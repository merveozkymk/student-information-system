package Nyp_Proje;

public class Akademisyen extends Kullanici {
    private String department; 

    public Akademisyen(String id, String name, String department, String password) {
        super(id, name, password); 
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Akademisyen Adı: " + getName() + ", Bölüm: " + department;
    }
}

