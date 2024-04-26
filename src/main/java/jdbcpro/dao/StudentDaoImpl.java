package jdbcpro.dao;

import jdbcpro.entities.Student;
import jdbcpro.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    //public static Connection con = null;
    @Override
    public int insertStudent(Student student) {
        int status = 0;

        try(Connection con = SQLConnector.createConnection()){
           // String sql =  "insert into student(name, gpa, address, grade) value('ra', 3.50, 'vienna', 'va', 'A')";
            String sql =  "insert into student(name, gpa, address, grade) value(?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setDouble(2, student.getGpa());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getGrade());



            status = preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try(Connection con = SQLConnector.createConnection()){
            // String sql =  "insert into student(name, gpa, address, grade) value('ra', 3.50, 'vienna', 'va', 'A')";
            String sql =  "select*from student";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultData = preparedStatement.executeQuery();

            while (resultData.next()){
                Student st = new Student();
                st.setId(resultData.getInt(1));
                st.setName(resultData.getString(2));
                st.setGpa(resultData.getDouble(3));
                st.setAddress(resultData.getString(4));
                st.setGrade(resultData.getString(5));

                students.add(st);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int updateStudent(int id, Student student) {
        int status = 0;
        List<Student> students = new ArrayList<>();
        try(Connection con = SQLConnector.createConnection()){
            // String sql =  "insert into student(name, gpa, address, grade) value('ra', 3.50, 'vienna', 'va', 'A')";
            String sql =  "update student set name=?, gpa=?, address=?, grade=? where id=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setDouble(2,student.getGpa());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getGrade());
            preparedStatement.setInt(5, id);

            status = preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }


    @Override
    public int deleteStudent(int id) {
        int status = 0;
        List<Student> students = new ArrayList<>();
        try(Connection con = SQLConnector.createConnection()){
            // String sql =  "insert into student(name, gpa, address, grade) value('ra', 3.50, 'vienna', 'va', 'A')";
            String sql =  "delete from student where id=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            status = preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
