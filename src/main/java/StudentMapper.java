import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface StudentMapper {
    @Select("SELECT * FROM students")
    List<Student> findAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student findById(int id);

    @Insert("INSERT INTO students (name, major) VALUES (#{name}, #{major})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Student student);

    @Update("UPDATE students SET name = #{name}, major = #{major} WHERE id = #{id}")
    void update(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void delete(int id);
}