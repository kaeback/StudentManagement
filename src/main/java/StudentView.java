import java.util.List;

// View
class StudentView {
    public void printStudentDetails(Student student) {
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("학생을 찾을 수 없습니다.");
        }
    }

    public void printAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            students.forEach(System.out::println);
        }
    }
}