package databaseHelper;

import connection.DatabaseConnection;
import data.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean didCurrentOperationSucceed = false;

    private ResultSet getAllRecordsFromDatabase(Connection connection) throws SQLException {
        String selectAllQuery = "SELECT * FROM courses;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
        return preparedStatement.executeQuery();
    }

    private void printCurrentTableData(ResultSet resultSet) throws SQLException {
        System.out.println("----");
        while (resultSet.next()) {
            // retrieve all the fields of a student into variables
            int courseID = resultSet.getInt("courseID");
            String courseName = resultSet.getString("courseName");
            String courseCode = resultSet.getString("courseCode");
            int courseDuration = resultSet.getInt("courseDuration");
            double courseCost = resultSet.getDouble("courseCost");
            Course course = new Course(courseID, courseName, courseCode, courseDuration, courseCost);
            System.out.println(course);
        }
        System.out.println("----\n");
    }

    public void readAllRecordsInStudentTable() throws SQLException {
        System.out.println("Student Table Records");
        System.out.println(String.format("|%-15s|%-40s|%-20s|%-15s|%-15s|", "CourseID", "CourseName", "CourseCode", "CourseDuration", "CourseCost"));
        this.printCurrentTableData(this.getAllRecordsFromDatabase(DatabaseConnection.getConnection()));
    }

    public int getCourseId() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String getCourseName() {
        return scanner.nextLine();
    }

    public String getCourseCode() {
        return scanner.nextLine();
    }

    public int getCourseDuration() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public double getCourseCost() {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    public void createNewCourseDatabase(Connection connection, Course course) throws SQLException {
        String insertQuery = "insert into courses(CourseID,CourseName,CourseCode,CourseDuration,CourseCost)Values(?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, course.getCourseID());
        preparedStatement.setString(2, course.getCourseName());
        preparedStatement.setString(3, course.getCourseCode());
        preparedStatement.setInt(4, course.getCourseDuration());
        preparedStatement.setDouble(5, course.getCourseCost());
        didCurrentOperationSucceed = preparedStatement.executeUpdate() >= 1;
    }

    public void checkIfCourseIsCreated() {
        System.out.println(didCurrentOperationSucceed ? "course created successfully" : "course couldn't be created");
    }

    //Searching
    public void searchCourse(String courseName) throws SQLException {
        String searchQuery = "select * from courses where CourseName ='" + courseName + "';";
        PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(searchQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        printCurrentTableData(resultSet);
    }
}
