package student;

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
 * Filename: CourseworkStudent.java
 */

public class CourseworkStudent extends Student {
    private double assignment1Marks;
    private double assignment2Marks;
    private double assignment3Marks;
    private double practicalWorkMarks;
    private double finalExaminationMarks;
    private double overallMarks;
    private String finalGrade;
    
    
    public CourseworkStudent() {
        super();
        overallMarks = 0.0;
        finalGrade = "N";
    }
    
    public CourseworkStudent(String newStudentType, String newStudentTitle, String newStudentFirstName, String newStudentLastName, long newStudentNumber, int newStudentDOB_Day, int newStudentDOB_Month, int newStudentDOB_Year, double newOverallMarks, String newFinalGrade) {
        super(newStudentType, newStudentTitle, newStudentFirstName, newStudentLastName, newStudentNumber, newStudentDOB_Day, newStudentDOB_Month, newStudentDOB_Year);
        overallMarks = newOverallMarks;
        finalGrade = newFinalGrade;
    }
    
    public void setAssignment1Marks(double newAssignment1Marks) {
        assignment1Marks = newAssignment1Marks;
    }
    
    public void setAssignment2Marks(double newAssignment2Marks) {
        assignment2Marks = newAssignment2Marks;
    }
            
    public void setAssignment3Marks(double newAssignment3Marks) {
        assignment3Marks = newAssignment3Marks;
    }
    
    public void setPracticalWorkMarks(double newPracticalWorkMarks) {
        practicalWorkMarks = newPracticalWorkMarks;
    }
    
    public void setFinalExaminationMarks(double newFinalExaminationMarks) {
        finalExaminationMarks = newFinalExaminationMarks;
    }
    
    public void setOverallMarks(double newOverallMarks) {
        overallMarks = newOverallMarks;
    }
    
    public void setFinalGrade(String newFinalGrade) {
        finalGrade = newFinalGrade;
    }
    
    public double getAssignment1Marks() {
        return assignment1Marks;
    }
    
    public double getAssignment2Marks() {
        return assignment2Marks;
    }
    
    public double getAssignment3Marks() {
        return assignment3Marks;
    }
    
    public double getPracticalWorkMarks() {
        return practicalWorkMarks;
    }
    
    public double getFinalExaminationMarks() {
        return finalExaminationMarks;
    }
    
    public double getOverallMarks() {
        return overallMarks;
    }
    
    public String getFinalGrade() {
        return finalGrade;
    }
    
    public double overallAssignmentMarks() {
        return ((assignment1Marks + assignment2Marks + assignment3Marks) / 3 * 0.45);
    }
    
    public double overallFinalExaminationMarks() {
        return (finalExaminationMarks * 0.35);
    }
    
    public void computeOverallMarks() {
        overallMarks = ( ((assignment1Marks + assignment2Marks + assignment3Marks) / 3 * 0.45) + practicalWorkMarks + (finalExaminationMarks * 0.35) );
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
    
    public String toString() {
        return super.toString() + "\nOverall Marks: " + overallMarks + "\nFinal Grade: " + finalGrade + "\n";
    }
    
}//end of class
