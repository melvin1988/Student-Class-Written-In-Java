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
 * Filename: ResearchStudent.java
 */

public class ResearchStudent extends Student {
    private double proposalComponentMarks;
    private double oralPresentation1Marks;
    private double oralPresentation2Marks;
    private double finalThesisMarks;
    private double overallMarks;
    private String finalGrade;
    
    public ResearchStudent() {
        proposalComponentMarks = 0.0;
        oralPresentation1Marks = 0.0;
        oralPresentation2Marks = 0.0;
        finalThesisMarks = 0.0;
        overallMarks = 0.0;
        finalGrade = "N";
    }
    
    public ResearchStudent(String newStudentType, String newStudentTitle, String newStudentFirstName, String newStudentLastName, long newStudentNumber, int newStudentDOB_Day, int newStudentDOB_Month, int newStudentDOB_Year, double newOverallMarks, String newFinalGrade) {
        super(newStudentType, newStudentTitle, newStudentFirstName, newStudentLastName, newStudentNumber, newStudentDOB_Day, newStudentDOB_Month, newStudentDOB_Year);
        overallMarks = newOverallMarks;
        finalGrade = newFinalGrade;
    }
    
    public void setProposalComponentMarks(double newProposalComponentMarks) {
        proposalComponentMarks = newProposalComponentMarks;
    }
    
    public void setOralPresentation1Marks(double newOralPresentation1Marks) {
        oralPresentation1Marks = newOralPresentation1Marks;
    }
    
    public void setOralPresentation2Marks(double newOralPresentation2Marks) {
        oralPresentation2Marks = newOralPresentation2Marks;
    }
    
    public void setFinalThesisMarks(double newFinalThesisMarks) {
        finalThesisMarks = newFinalThesisMarks;
    }
    
    public void setOverallMarks(double newOverallMarks) {
        overallMarks = newOverallMarks;
    }
    
    public void setFinalGrade(String newFinalGrade) {
        finalGrade = newFinalGrade;
    }
    
    public double getProposalComponentMarks() {
        return proposalComponentMarks;
    }
    
    public double getOralPresentation1Marks() {
        return oralPresentation1Marks;
    }
    
    public double getOralPresentation2Marks() {
        return oralPresentation2Marks;
    }
    
    public double getFinalThesisMarks() {
        return finalThesisMarks;
    }
    
    public double getOverallMarks() {
        return overallMarks;
    }
    
    public String getFinalGrade() {
        return finalGrade;
    }
    
    public double overallProposalComponentMarks() {
        return (proposalComponentMarks * 0.3);
    }
    
    public double overallOralPresentationMarks() {
        return ((oralPresentation1Marks + oralPresentation2Marks) / 2 * 0.2);
    }
    
    public double overallFinalThesisMarks() {
        return (finalThesisMarks * 0.5);
    }
    
    public void computeOverallMarks() {
        overallMarks = ( (proposalComponentMarks * 0.3) + ((oralPresentation1Marks + oralPresentation2Marks) / 2 * 0.2) + (finalThesisMarks * 0.5) );
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
