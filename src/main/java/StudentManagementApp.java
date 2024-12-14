import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepositoryImpl();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(repository, view);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 학생 추가\n2. 학생 수정\n3. 학생 삭제\n4. 학생 조회\n5. 모든 학생 조회\n6. 종료");
            System.out.print("옵션을 선택하세요: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // 줄바꿈 제거

            switch (option) {
                case 1 -> {
                    System.out.print("학생 이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("학생 전공을 입력하세요: ");
                    String major = scanner.nextLine();
                    controller.addStudent(name, major);
                }
                case 2 -> {
                    System.out.print("수정할 학생 ID를 입력하세요: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // 줄바꿈 제거
                    System.out.print("새 이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("새 전공을 입력하세요: ");
                    String major = scanner.nextLine();
                    controller.updateStudent(id, name, major);
                }
                case 3 -> {
                    System.out.print("삭제할 학생 ID를 입력하세요: ");
                    int id = scanner.nextInt();
                    controller.deleteStudent(id);
                }
                case 4 -> {
                    System.out.print("조회할 학생 ID를 입력하세요: ");
                    int id = scanner.nextInt();
                    controller.showStudent(id);
                }
                case 5 -> controller.showAllStudents();
                case 6 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("잘못된 옵션입니다. 다시 시도하세요.");
            }
        }
    }
}