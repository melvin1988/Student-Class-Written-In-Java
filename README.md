# Student-Class-Written-In-Java
First, you need to design, code in Java, test and document a base class, Student. The Student class will
have the following information:

A. Title of the student (eg Mr, Miss, Ms, Mrs etc)
B. A first name (given name)
C. A last name (family name/surname)
D. Student number (ID) – an integer number (of type long)
E. A date of birth (in day/month/year format – three ints) - (Do NOT use the Date class from
JAVA)

The student class will have at least the following constructors and methods:

(i) two constructors - one without any parameters (the default constructor), and one with
parameters to give initial values to all the instance variables.
(ii) a reasonable number of set and get methods.
(iii) methods to compute the final overall mark and the final grade (which will be overridden in
the respective child classes). These two methods will be void methods that set the
appropriate instance variables. Remember one method can call another method. If you prefer,
you can define a single method that sets both the overall mark and the final string grade, but
if you do this, use a helper method.
(iv) an equals method which compares two student objects and returns true if they have the same
student names, and the same date of birth, otherwise it returns false.
(v) method to sort the array into ascending order of students’ numbers (IDs)

You may add other methods in the student class as you see appropriate.

Design, code in Java, test and document (at least) three classes – a CourseWorkStudent class, a
ResearchStudent class (which both derive from the Student class) and a client program.

For coursework students:

(a) There are three assignments, each marked out of a maximum of 100 marks and equally weighted.
The marks for each assignment are recorded separately.
(b) There is weekly practical work. The marks for this component are recorded as a total mark
obtained (out of a maximum of 20 marks) for all practical work demonstrated during the semester.
(c) There is one final examination that is marked out of a maximum of 100 marks and recorded
separately.
(d) An overall mark (to be calculated within the program)
(e) A final grade, which is a string (to be calculated within the program)

The final grade, for coursework students, is to be awarded on the basis of an overall mark, which is a
number in the range 0 to 100 and is obtained by calculating the weighted average of the student's
performance in the assessment components. The criteria for calculating the weighted average is as
defined below:

The two assignments together count for a total of 45% (15% each) of the final grade, the
practical work is worth 20%, and the final exam is worth 35% of the final grade.

For research students:

(a) There is a proposal component (out of a maximum of 100 marks).
(b) Two oral presentations (out of a maximum of 100 marks).
(c) There is one final thesis that is marked out of a maximum of 100 marks and recorded separately.
(d) An overall mark (to be calculated within the program)
(e) A final grade, which is a string (to be calculated within the program)

The final grade, for research students, is to be awarded on the basis of an overall mark, which is a
number in the range 0 to 100 and is obtained by calculating the weighted average of the student's
performance in the assessment components. The criteria for calculating the weighted average is as
defined below:

The proposal component is worth 30% of the final grade, the two oral presentations are worth
a total of 20% (10% each), and the final thesis is worth 50% of the final grade

A grade is to be awarded for coursework and research students as follows: An overall mark of 80 or
higher is an HD, an overall mark of 70 or higher (but less than 80) is a D, an overall mark of 60 or
higher (but less than 70) is a C, an overall mark of 50 or higher (but less than 60) is a P, and an overall
mark below 50 is an N.

The client program will allow entry of these data for several different student into an arraylist and
then perform some analysis and queries.

Your client class (program) will provide the user with a menu to perform the following operations.
You will need to think of a way to ask the user whether they are dealing with the coursework student
or research student before going into the appropriate menu. You will also need to load the information
of the students from a text file (student.txt) before displaying the menu.

1. Quit (exit the program)
2. Add (to the arraylist) all information about a coursework or research student (except the
overall mark and the grade) by reading it from another text file and determine the student’s
overall mark and grade.
3. Output from the arraylist the details (all information including the overall mark and the grade)
of all students currently held in the arraylist
4. Compute and output the average overall mark for coursework or research students
5. Determine and display how many coursework or research students obtained an overall mark
equal to or above the average overall mark and how many obtained an overall mark below the
average overall mark
6. Given a coursework or research student number (ID), view all details of the student with that
number. If the student is not found in the arraylist, an appropriate error message is to be
displayed
7. Given a coursework or research student’s name (both surname and given name – ignoring
case), view all details of that student. If the student is not found in the arraylist, an appropriate
error message is to be displayed
8. Sort the arraylist of the student objects into ascending order of the students’ numbers (IDs),
and output the sorted array
9. Output the sorted arraylist from (8) to a CSV file.

Note that the program will loop around until the user selects the first option (Quit).

Set up a student arraylist of N student objects, and test it with N = 10 (at least). You have to
store your test data in a file so that your program can read them.

The client class should be well-structured and should have a reasonable number of methods in addition
to the main method.

The interaction with the user can be via the command line (i.e., no graphical user interface is
expected).

Devise suitable test data to test all sections of program code. You will need to provide all the test data
used.

Your program should also include a method (e.g., StudentInfo( )) to output your student details
(name, student number, mode of enrolment, tutor name, tutorial attendance day and time) at the start
of program results.

Note: The question requires you to use an ArrayList. Also, the sorting algorithm used must be
coded within your program and not called from any Java libraries. You should not use any
Java libraries for sorting algorithm, date and output to CSV file (e.g. FileWriter).
