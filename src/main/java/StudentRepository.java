import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

class StudentRepository {
    private final SqlSessionFactory sqlSessionFactory;

    public StudentRepository() {
        InputStream inputStream = StudentManagementApp.class.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public List<Student> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.findAll();
        }
    }

    public Student findById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.findById(id);
        }
    }

    public void save(Student student) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.save(student);
        }
    }

    public void update(Student student) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.update(student);
        }
    }

    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.delete(id);
        }
    }
}
