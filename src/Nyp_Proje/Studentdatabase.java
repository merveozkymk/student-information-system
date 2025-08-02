package Nyp_Proje;

import java.util.Collection;
import java.util.HashMap;

public class Studentdatabase implements LoginInterface{
	private static HashMap<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();

        Student student1 = new Student("001", "Ahmet Yılmaz", "abc");
        student1.addCourse(new Course("Matematik", "AA"));
        student1.addCourse(new Course("Fizik", "BB"));
        addStudent(student1);

        Student student2 = new Student("002", "Ayşe Demir", "cdf");
        student2.addCourse(new Course("Kimya", "CC"));
        addStudent(student2);

    }

    public static void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public static Student getStudentById(String studentId) {
        return studentMap.get(studentId);  
    }

    public boolean login(String id, String password) {
        Student student = studentMap.get(id);
        if (student != null && student.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public static Collection<Student> listAllStudents() {
        return studentMap.values();
    }
}
