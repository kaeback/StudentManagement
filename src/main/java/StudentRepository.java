import java.util.ArrayList;
import java.util.List;

class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public void save(Student student) {
        student = new Student(nextId++, student.getName(), student.getMajor());
        students.add(student);
    }

    public void update(int id, Student updatedStudent) {
        Student student = findById(id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setMajor(updatedStudent.getMajor());
        }
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
