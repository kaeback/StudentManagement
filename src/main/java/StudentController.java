class StudentController {
    private final StudentRepository repository;
    private final StudentView view;

    public StudentController(StudentRepository repository, StudentView view) {
        this.repository = repository;
        this.view = view;
    }

    public void addStudent(String name, String major) {
        repository.save(new Student(0, name, major));
    }

    public void updateStudent(int id, String name, String major) {
        repository.update(id, new Student(id, name, major));
    }

    public void deleteStudent(int id) {
        repository.delete(id);
    }

    public void showStudent(int id) {
        view.printStudentDetails(repository.findById(id));
    }

    public void showAllStudents() {
        view.printAllStudents(repository.findAll());
    }
}
