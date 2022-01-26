package student;

import java.util.ArrayList;

/**
 * Student Data Handler
 * ====================
 * The first purpose of this program is to compute the overall marks for coursework students and research students based on the different formulas provided:
 * For coursework students, the three assignments together count for a total of 45% (15% each) of the final grade, the practical work is worth 20%, and the final exam is worth 35% of the final grade
 * For research students, the proposal component is worth 30% of the final grade, the two oral presentations are worth a total of 20% (10% each), and the final thesis is worth 50% of the final grade
 * 
 * The second purpose of this program is to determine the final grade for all students based on the criteria:
 * An overall mark of 80 or higher is an HD
 * An overall mark of 70 or higher (but less than 80) is a D
 * An overall mark of 60 or higher (but less than 70) is a C
 * An overall mark of 50 or higher (but less than 60) is a P
 * An overall mark below 50 is an N
 * 
 * This program also:
 * Stores students' personal particulars
 * Allows addition of students' personal particulars
 * Allows searching for a particular student by entering his/her student number (ID) or first name and last name
 * Computes the average overall mark
 * Determines the number of students above and equal to, or below the average overall mark
 * Outputs data from the arraylist to a CSV file
 * 
 * @author Melvin Sim
 * 16 July 2020
 * Version 1.0
 * Filename: Student.java
 */

public abstract class Student {
    private String studentType;
    private String studentTitle;
    private String studentFirstName;
    private String studentLastName;
    private long studentNumber;
    private int studentDOB_Day;
    private int studentDOB_Month;
    private int studentDOB_Year;
    private double marks1;
    private double marks2;
    private double marks3;
    private double overallMarks;
    private String finalGrade;
    
    public Student() {
        studentType = "Student type not defined";
        studentTitle = "Mr/Ms";
        studentFirstName = "No first name yet";
        studentLastName = "No last name yet";
        studentNumber = 0;
        studentDOB_Day = 1;
        studentDOB_Month = 1;
        studentDOB_Year = 1980;
    }
    
    public Student(String newStudentType, String newStudentTitle, String newStudentFirstName, String newStudentLastName, long newStudentNumber, int newStudentDOB_Day, int newStudentDOB_Month, int newStudentDOB_Year) {
        studentType = newStudentType;
        studentTitle = newStudentTitle;
        studentFirstName = newStudentFirstName;
        studentLastName = newStudentLastName;
        studentNumber = newStudentNumber;
        studentDOB_Day = newStudentDOB_Day;
        studentDOB_Month = newStudentDOB_Month;
        studentDOB_Year = newStudentDOB_Year;
    }
    
    public void setStudent(String newStudentType, String newStudentTitle, String newStudentFirstName, String newStudentLastName, long newStudentNumber, int newStudentDOB_Day, int newStudentDOB_Month, int newStudentDOB_Year) {
        studentType = newStudentType;
        studentTitle = newStudentTitle;
        studentFirstName = newStudentFirstName;
        studentLastName = newStudentLastName;
        studentNumber = newStudentNumber;
        studentDOB_Day = newStudentDOB_Day;
        studentDOB_Month = newStudentDOB_Month;
        studentDOB_Year = newStudentDOB_Year;
    }
    
    public void setStudentType(String newStudentType) {
        studentType = newStudentType;
    }
    
    public void setStudentTitle(String newStudentTitle) {
        studentTitle = newStudentTitle;
    }
    
    public void setStudentFirstName(String newStudentFirstName) {
        studentFirstName = newStudentFirstName;
    }
    
    public void setStudentLastName(String newStudentLastName) {
        studentLastName = newStudentLastName;
    }
    
    public void setStudentNumber(long newStudentNumber) {
        studentNumber = newStudentNumber;
    }
    
    public void setStudentDOB_Day(int newStudentDOB_Day) {
        studentDOB_Day = newStudentDOB_Day;
    }
    
    public void setStudentDOB_Month(int newStudentDOB_Month) {
        studentDOB_Month = newStudentDOB_Month;
    }
    
    public void setStudentDOB_Year(int newStudentDOB_Year) {
        studentDOB_Year = newStudentDOB_Year;
    }
    
    public String getStudentType() {
        return studentType;
    }
    
    public String getStudentTitle() {
        return studentTitle;
    }
    
    public String getStudentFirstName() {
        return studentFirstName;
    }
    
    public String getStudentLastName() {
        return studentLastName;
    }
    
    public long getStudentNumber() {
        return studentNumber;
    }
    
    public int getStudentDOB_Day() {
        return studentDOB_Day;
    }
    
    public int getStudentDOB_Month() {
        return studentDOB_Month;
    }
    
    public int getStudentDOB_Year() {
        return studentDOB_Year;
    }
    
    public double getMarks1() {
        return marks1;
    }
    
    public double getMarks2() {
        return marks2;
    }
    
    public double getMarks3() {
        return marks3;
    }
    
    public double getOverallMarks() {
        return overallMarks;
    }
    
    public String getFinalGrade() {
        return finalGrade;
    }
    
    public void computeOverallMarks() {
        overallMarks = (marks1 + marks2 + marks3);
    }
    
    public void computeFinalGrade() {
        if(overallMarks >= 80)
            finalGrade = "HD";
        if(overallMarks < 80 && overallMarks >= 70)
            finalGrade = "D";
        if(overallMarks < 70 && overallMarks >= 60)
            finalGrade = "C";
        if(overallMarks < 60 && overallMarks >= 50)
            finalGrade = "P";
        else if(overallMarks < 50)
            finalGrade = "N";
    }
    
    public boolean equalsStudent(String otherStudentFirstName, String otherStudentLastName, int otherStudentDOB_Day, int otherStudentDOB_Month, int otherStudentDOB_Year) {
        if(studentFirstName.equals(otherStudentFirstName) && studentLastName.equals(otherStudentLastName) && studentDOB_Day == otherStudentDOB_Day && studentDOB_Month == otherStudentDOB_Month && studentDOB_Year == otherStudentDOB_Year)
            return true;
        return false;
    }
    
    //used in Main.java to sort arraylist into ascending order of students' numbers (IDs)
    public boolean compareStudentNumber(long otherStudentNumber) {
        if(studentNumber > otherStudentNumber)
            return true;
        else
            return false;
    }
    
    public String toString() {
        return studentType + "\nName: " + studentTitle + " " + studentFirstName + " " + studentLastName + "\nStudent Number: " + studentNumber + "\nDate of Birth: " + studentDOB_Day + "/" + studentDOB_Month + "/" + studentDOB_Year;
    }
    
}//end of class
