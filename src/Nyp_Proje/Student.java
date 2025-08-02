package Nyp_Proje;
import java.util.ArrayList;
import java.util.List;

public class Student extends Kullanici implements StudentInterface, PasswordInterface{
    private List<Course> courses;
  
    public Student(String id, String name, String password) {
    	super(id, name, password);
        this.courses = new ArrayList<>();
    }
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
    @Override
    public String getStudentName() {
        return getName();  
    }

    @Override
    public String getStudentId() {
        return getId(); 
    }
    
    @Override
	public void updatePassword(String newPassword) {
		
	}

    @Override
    public String toString() {
        return "Öğrenci Adı: " + getName();
    }
	
}
