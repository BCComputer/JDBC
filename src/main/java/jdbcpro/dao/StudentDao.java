package jdbcpro.dao;

import jdbcpro.entities.Student;

import java.util.List;

public interface StudentDao {
    //public int insertStudent();
   public int insertStudent(Student student);

    public List<Student> getAllStudents();
    public int updateStudent(int id, Student student);
    public int deleteStudent(int id);


}
