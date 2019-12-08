package data;

public class Course {
    private int courseID;
    private String courseName;
    private String courseCode;
    private int courseDuration;
    private double courseCost;

    public Course(int courseID, String courseName, String courseCode, int courseDuration, double courseCost) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseDuration = courseDuration;
        this.courseCost = courseCost;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public double getCourseCost() {
        return courseCost;
    }

    @Override
    public String toString() {
        return String.format("|%-15d|%-40s|%-20s|%-15d|%-15.2f|", this.getCourseID(), this.getCourseName(),
                this.getCourseCode(), this.getCourseDuration(), this.getCourseCost());
    }
}
