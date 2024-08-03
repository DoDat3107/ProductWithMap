import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentManager {
    private Map<Integer, Student> studentList = new HashMap<>();

    public void saveStudent(Student student) {
        studentList.put(student.getId(), student);
    }

    public void deleteStudent(int id) {
        studentList.remove(id);
    }

    public Student getStudentById(int id) {
        return studentList.get(id);
    }

    public Map<Integer, Student> getAllStudents() {
        return studentList;
    }

    public Map<Integer, Student> getStudentByName(String name) {
        Map<Integer, Student> result = new HashMap<>();
        for (Student student : studentList.values()) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.put(student.getId(), student);
            }
        }
        return result;
    }

    public Student getMaxAvg() {
        Student topStudent = null;
        double maxAvgScore = 0;
        for (Student student : studentList.values()) {
            double avg = student.getAvg();
            if (avg > maxAvgScore) {
                maxAvgScore = avg;
                topStudent = student;
            }
        }
        return topStudent;
    }
}
