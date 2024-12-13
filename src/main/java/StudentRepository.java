import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class StudentRepository {
    private final String url = "jdbc:mysql://localhost:3306/students";
    private final String username = "student";
    private final String password = "1234";

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("major")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("major"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Student student) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO students (name, major) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getMajor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Student updatedStudent) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE students SET name = ?, major = ? WHERE id = ?")) {

            statement.setString(1, updatedStudent.getName());
            statement.setString(2, updatedStudent.getMajor());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
