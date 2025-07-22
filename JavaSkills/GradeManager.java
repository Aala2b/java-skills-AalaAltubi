

public class GradeManager {
    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String original = names[i];
            String reversed = " "; //empty string
            for (int j = original.length() - 1; j >= 0; j--) {
                reversed += original.charAt(j);
            }//end inner for loop
            reversedNames[i] = reversed;
        }//end outer for loop
        return reversedNames;
    } //end reverse method

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100)
            return 'A';
        else if (score >= 80 && score <= 89)
            return 'B';
        else if (score >= 70 && score <= 79)
            return 'C';
        else if (score >= 60 && score <= 69)
            return 'D';
        else
            return 'F';
    }    // end letter grade method

    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores) {
        int failCount = 0;
        for (int j = 0; j < scores.length; j++) {
            if (scores[j] < 60)
                failCount++; //count n.o of fails to initialize the array of names
        }
        String[] failingStudents = new String[failCount]; //initialize array
        int k = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failingStudents[k++] = names[i];
            }
        } //end for loop
        return failingStudents;
    } //end method

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        System.out.println("----Reversed student names----");
        String[] reversed = reverseStudentNames(students);
        for (String names : reversed) {
            System.out.println(names);
        }
        //print grades
        System.out.println("\n Student grades");
        for (int i = 0; i < students.length; i++) {
            char grades = getLetterGrade(scores[i]);
            System.out.println(students[i] + " Score: " + scores[i] + " Grade " + grades);
        }
        System.out.println("\n Students who need to retake the exam:");
        String[] failing = findFailingStudents(students, scores);
        if (failing.length == 0) {
            System.out.println("All students passed!");
        } else {
            for (String name : failing) {
                System.out.println(name);
            }


        } //end main
    }
}
