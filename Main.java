package student;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
 * Filename: Main.java
 */

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        studentInfo();
        ArrayList<Student> studentList = new ArrayList<Student>();
        
        //load information of students from student.txt before displaying menu
        getCourseworkArrayList(studentList, "student.txt");
        getResearchArrayList(studentList, "student.txt");
                
        //ask the user whether they are dealing with the coursework student or research student before going into the appropriate menu
        String menuChoice = getMenuChoice();
        if(menuChoice.equalsIgnoreCase("c")) {
            while(true) {
                displayCourseworkMenu();
                int courseworkMenuInput = getMenuInput("\nEnter your choice (between 1-9):", 1, 9);
                switch(courseworkMenuInput) {
                    case 2:
                        getCourseworkArrayList(studentList, "another.txt");
                        printLastElementOfArrayList(studentList);
                        break;

                    case 3:
                        printArrayList(studentList);
                        break;

                    case 4:
                        double averageOverallMark = computeCourseworkAverageOverallMark(studentList);
                        System.out.println("The average overall mark is " + averageOverallMark);
                        break;

                    case 5:
                        printCourseworkEqualToAndAboveOrBelowAverageOverallMark(studentList);
                        break;

                    case 6:
                        long studentNumberInput = getStudentNumberInput("Enter a student number:");
                        searchStudentNumber(studentList, studentNumberInput);
                        break;

                    case 7:
                        String firstNameInput = getStringInput("Enter student's first name:");
                        String lastNameInput = getStringInput("Enter student's last name:");
                        searchStudentName(studentList, firstNameInput, lastNameInput);
                        break;

                    case 8:
                        sortStudentNumberInAscending(studentList);
                        printArrayList(studentList);
                        break;

                    case 9:
                        sortStudentNumberInAscending(studentList);
                        outputFile(studentList);
                        break;
                }//end of switch
                if(courseworkMenuInput == 1) {
                    exitMenu("You quit. Goodbye!");
                        break;
                }//end of if
            }//end of while
        }//end of if
        
        if(menuChoice.equalsIgnoreCase("r")) {
            while(true) {
                displayResearchMenu();
                int researchMenuInput = getMenuInput("\nEnter your choice (between 1-9):", 1, 9);
                switch(researchMenuInput) {
                    case 2:
                        getResearchArrayList(studentList, "another.txt");
                        printLastElementOfArrayList(studentList);                     
                        break;

                    case 3:
                        printArrayList(studentList);
                        break;

                    case 4:
                        double averageOverallMark = computeResearchAverageOverallMark(studentList);
                        System.out.println("The average overall mark is " + averageOverallMark);
                        break;

                    case 5:
                        printResearchEqualToAndAboveOrBelowAverageOverallMark(studentList);
                        break;

                    case 6:
                        long studentNumberInput = getStudentNumberInput("Enter a student number:");
                        searchStudentNumber(studentList, studentNumberInput);
                        break;

                    case 7:
                        String firstNameInput = getStringInput("Enter student's first name:");
                        String lastNameInput = getStringInput("Enter student's last name:");
                        searchStudentName(studentList, firstNameInput, lastNameInput);
                        break;

                    case 8:
                        sortStudentNumberInAscending(studentList);
                        printArrayList(studentList);
                        break;

                    case 9:
                        sortStudentNumberInAscending(studentList);
                        outputFile(studentList);
                        break;
                }//end of switch
                if(researchMenuInput == 1) {
                    exitMenu("You quit. Goodbye!");
                        break;
                }//end of if
            }//end of while
        }//end of if
        
    }//end of Main
    
    private static void getCourseworkArrayList(ArrayList<Student> data, String file) {
        String fileName = file;
        Scanner inputStream = null;
        
        try {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
        
        while(inputStream.hasNextLine()) {
            String longString = inputStream.nextLine();
            String[] parts = longString.trim().split(",");
            CourseworkStudent s = new CourseworkStudent();
            if(parts[0].equalsIgnoreCase("c")) {
                s.setStudentType("Coursework Student");
                s.setAssignment1Marks(Double.parseDouble(parts[8]));
                s.setAssignment2Marks(Double.parseDouble(parts[9]));
                s.setAssignment3Marks(Double.parseDouble(parts[10]));
                s.setPracticalWorkMarks(Double.parseDouble(parts[11]));
                s.setFinalExaminationMarks(Double.parseDouble(parts[12]));
                s.computeOverallMarks();
                double overallMarks = s.getOverallMarks();
                s.computeFinalGrade();
                String finalGrade = s.getFinalGrade();
                s = new CourseworkStudent(s.getStudentType(), parts[1], parts[2], parts[3], Long. parseLong(parts[4]), Integer. parseInt(parts[5]), Integer. parseInt(parts[6]), Integer. parseInt(parts[7]), overallMarks, finalGrade);
                data.add(s);
            }
        }
        inputStream.close();
    }
    
    private static void getResearchArrayList(ArrayList<Student> data, String file) {
        String fileName = file;
        Scanner inputStream = null;
        
        try {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
        
        while(inputStream.hasNextLine()) {
            String longString = inputStream.nextLine();
            String[] parts = longString.trim().split(",");
            ResearchStudent s = new ResearchStudent();
            if(parts[0].equalsIgnoreCase("r")) {
                s.setStudentType("Research Student");
                s.setProposalComponentMarks(Double.parseDouble(parts[8]));
                s.setOralPresentation1Marks(Double.parseDouble(parts[9]));
                s.setOralPresentation2Marks(Double.parseDouble(parts[10]));
                s.setFinalThesisMarks(Double.parseDouble(parts[10]));
                s.computeOverallMarks();
                double overallMarks = s.getOverallMarks();
                s.computeFinalGrade();
                String finalGrade = s.getFinalGrade();
                s = new ResearchStudent(s.getStudentType(), parts[1], parts[2], parts[3], Long. parseLong(parts[4]), Integer. parseInt(parts[5]), Integer. parseInt(parts[6]), Integer. parseInt(parts[7]), overallMarks, finalGrade);
                data.add(s);
            }
        }
        inputStream.close();
    }
    
    private static void printLastElementOfArrayList(ArrayList<Student> data) {
        System.out.println(data.get(data.size()-1));
    }
    
    private static String getMenuChoice() {
        System.out.println("Enter 'c' to access information on coursework students.");
        System.out.println("Enter 'r' to access information on research students.");
        String input = keyboard.nextLine().trim();
        while( !(input.equals("c") || input.equals("r")) ) {
            System.out.println("Wrong input, please re-enter:");
            input = keyboard.nextLine().trim();
        }
        return input;
    }
    
    private static void displayCourseworkMenu() {
        System.out.println("\n1. Quit (exit the program)");
        System.out.println("2. Display all information about a coursework student by reading it from the file (another.txt) and adding it to the arraylist");
        System.out.println("3. Display all information of all the students currently held in the arraylist");
        System.out.println("4. Display the average overall mark for coursework students");
        System.out.println("5. Display the number of coursework students equal to and above, or below the average overall mark");
        System.out.println("6. View all details of a student by entering his/her student number (ID)");
        System.out.println("7. View all details of a student by entering his/her first name and last name");
        System.out.println("8. Display all information of all the students in ascending order, ordered by the students’ numbers (IDs)");
        System.out.println("9. Output all information from (8) to a CSV file");
    }
    
    private static void displayResearchMenu() {
        System.out.println("\n1. Quit (exit the program)");
        System.out.println("2. Display all information about a research student by reading it from the file (another.txt) and adding it to the arraylist");
        System.out.println("3. Display all information of all the students currently held in the arraylist");
        System.out.println("4. Display the average overall mark for research students");
        System.out.println("5. Display the number of research students equal to and above, or below the average overall mark");
        System.out.println("6. View all details of a student by entering his/her student number (ID)");
        System.out.println("7. View all details of a student by entering his/her first name and last name");
        System.out.println("8. Display all information of all the students in ascending order, ordered by the students’ numbers (IDs)");
        System.out.println("9. Output all information from (8) to a CSV file");
    }
    
    private static int getMenuInput(String msg, int min, int max) {
        int input;
        
        while(true) {
            try {
                System.out.println(msg);
                input = keyboard.nextInt();
                keyboard.nextLine();
                if((input >= min) && (input <= max))
                    break;
            }
            catch(Exception e) {
                keyboard.nextLine();
                System.out.println("Wrong input data type.");
            }
            System.out.println("Please enter a number between " + min + "-" + max);
        }
        return input;
      }
    
    private static void printArrayList(ArrayList<Student> data) {
        for(Student s : data)
            System.out.println(s);
    }
    
    private static double computeCourseworkAverageOverallMark(ArrayList<Student> data) {
        double sum = 0.0;
        int count = 0;
        
        for(Student s : data)
            if(s.getStudentType().equals("Coursework Student")) {
                sum = sum + s.getOverallMarks();
                count++;
            }
        return sum / count;
    }
    
    private static double computeResearchAverageOverallMark(ArrayList<Student> data) {
        double sum = 0.0;
        int count = 0;
        
        for(Student s : data)
            if(s.getStudentType().equals("Research Student")) {
                sum = sum + s.getOverallMarks();
                count++;
            }
        return sum / count;
    }
    
    private static void printCourseworkEqualToAndAboveOrBelowAverageOverallMark(ArrayList<Student> data) {
        int aboveAverage = 0;
        int belowAverage = 0;
        
        for(Student s : data) {
            if(s.getStudentType().equals("Coursework Student") && s.getOverallMarks() >= computeCourseworkAverageOverallMark(data))
                aboveAverage++;
            if(s.getStudentType().equals("Coursework Student") && s.getOverallMarks() < computeCourseworkAverageOverallMark(data))
                belowAverage++;
        }
        System.out.println("Number of coursework students with overall mark equal to or above the average overall mark: " + aboveAverage);
        System.out.println("Number of coursework students with overall mark below the average overall mark: " + belowAverage);
    }
    
    private static void printResearchEqualToAndAboveOrBelowAverageOverallMark(ArrayList<Student> data) {
        int aboveAverage = 0;
        int belowAverage = 0;
        
        for(Student s : data) {
            if(s.getStudentType().equals("Research Student") && s.getOverallMarks() >= computeResearchAverageOverallMark(data))
                aboveAverage++;
            if(s.getStudentType().equals("Research Student") && s.getOverallMarks() < computeResearchAverageOverallMark(data))
                belowAverage++;
        }
        System.out.println("Number of research students with overall mark equal to or above the average overall mark: " + aboveAverage);
        System.out.println("Number of research students with overall mark below the average overall mark: " + belowAverage);
    }
    
    private static long getStudentNumberInput(String msg) {
        long input;
        
        while(true) {
            try {
                System.out.println(msg);
                input = keyboard.nextLong();
                keyboard.nextLine();
                if(input >= 0)
                    break;
            }
            catch(Exception e) {
                keyboard.nextLine();
                System.out.println("Wrong input data type.");
            }
            System.out.println("Student number must be a number that is non-negative.");
        }
        return input;
    }
    
    private static void searchStudentNumber(ArrayList<Student> data, long number) {
        int count = 0;
        
        for(Student s : data) {
            if(s.getStudentNumber() == number) {
                System.out.println(s);
                count++;
            }
        }
        
        if(count == 0)
            System.out.println("Student does not exist.");
    }
    
    private static String getStringInput(String msg) {
        System.out.println(msg);
        String input = keyboard.nextLine();
        return input;
    }
    
    private static void searchStudentName(ArrayList<Student> data, String firstName, String lastName) {
        int count = 0;

        for(Student s : data) {
            if(s.getStudentFirstName().equalsIgnoreCase(firstName) && s.getStudentLastName().equalsIgnoreCase(lastName)) {
                System.out.println(s);
                count++;
            }
        }
        
        if(count == 0)
            System.out.println("Student does not exist.");
    }
    
    private static void sortStudentNumberInAscending(ArrayList<Student> data) {
        for(int i = 1; i < data.size(); i++) {
            Student temp = data.get(i);
            int j = i - 1;
            while( (j > -1) && (data.get(j).compareStudentNumber(temp.getStudentNumber())) ) {
                data.set(j+1, data.get(j));
                j--;
            }
            data.set(j+1, temp);
        }
    }
    
    private static void outputFile(ArrayList<Student> data) {
        PrintWriter outputStream = null;
        String outputFileName = getFileName("Enter the name of the CSV file: ");
        
        try {
            outputStream = new PrintWriter(outputFileName);
        }
        catch(FileNotFoundException e) {
            System.out.println("Error in opening the file " + outputFileName);
            System.exit(0);
        }
        
        for(Student s : data)
            outputStream.println(s.getStudentType() + "\nName: " + s.getStudentTitle() + " " + s.getStudentFirstName() + " " + s.getStudentLastName() + "\nStudent Number: " + s.getStudentNumber() + "\nDate of Birth: " + s.getStudentDOB_Day() + "/" + s.getStudentDOB_Month() + "/" + s.getStudentDOB_Year() + "\nOverall Marks: " + s.getOverallMarks() + "\nFinal Grade: " + s.getFinalGrade() + "\n");
        outputStream.close();
        System.out.println("Data have been written to " + outputFileName);
    }
    
    private static String getFileName(String msg) {
        System.out.println(msg);
        String fileName = keyboard.nextLine();
        return fileName;
    }
    
    private static void exitMenu(String msg) {
        System.out.println(msg);
    }
    
    private static void studentInfo() {
        System.out.println("Name: Melvin Sim");
        System.out.println("Student number: 32878244");
        System.out.println("Mode of enrolment: Part-time");
        System.out.println("Tutor: Kevin Ng");
        System.out.println("===================================================================");
        System.out.println("");
    }
    
}//end of class
