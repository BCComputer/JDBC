package jdbcpro.controller;

import jdbcpro.dao.StudentDaoImpl;
import jdbcpro.entities.Student;
import jdbcpro.util.SQLConnector;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Student Class");


        System.out.println("PLease enter your name");
        String name = scanner.nextLine();

        System.out.println("PLease enter your gpa");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("PLease enter your address");
        String address = scanner.nextLine();

        System.out.println("PLease enter your grade");
        String grade = scanner.nextLine();

        System.out.println("Do you want add more student?");


        SQLConnector sqlConnector = new SQLConnector();
        Connection connection = SQLConnector.createConnection();
        System.out.println(connection);


        StudentDaoImpl studentDao = new StudentDaoImpl();

        Student s1 = new Student(name, gpa, address, grade);
        studentDao.insertStudent(s1);
        List<Student> allStudents = studentDao.getAllStudents();

        System.out.println(allStudents.toString());

        Student s2 = new Student("nat", 3.85, "Manasas, VA", "A");

        int status = studentDao.updateStudent(1, s2);
        if (status > 0) {
            System.out.println("Successful");
        } else {
            System.out.println(studentDao.getAllStudents());
        }

        int deleteStatus = studentDao.deleteStudent(2);
        if (deleteStatus < 0) {
            System.out.println("fail");
        } else {
            System.out.println(studentDao.getAllStudents());
        }
    }

}
