package Main;

import connection.DatabaseConnection;
import databaseHelper.DatabaseHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.attemptConnection();
        DatabaseHelper dis = new DatabaseHelper();

        /*Course Creation


        int id = dis.getCourseId();
        String name = dis.getCourseName();
        String code = dis.getCourseCode();
        int year = dis.getCourseDuration();
        double cost = dis.getCourseCost();
        Course course = new Course(id,name,code,year,cost);
        dis.createNewCourseDatabase(DatabaseConnection.getConnection(),course);
        dis.checkIfCourseIsCreated();

        */

        //Displaying the Records
        dis.readAllRecordsInStudentTable();

        //Searching for Specific Course
        System.out.println("Enter Course Name to search it");
        String name = dis.getCourseName();
        dis.searchCourse(name);
    }
}
