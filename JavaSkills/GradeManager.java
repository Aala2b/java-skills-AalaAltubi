import java.sql.SQLOutput;

public class GradeManager {
// Method to reverse student names in an array
public static String[] reverseStudentNames(String[] names) {

} //end reverse method

    // Method to calculate letter grades
    public static char getLetterGrade(int score){
    if(score>=90 && score<=100)
        return 'A';
    else if (score>=80 && score<=89)
        return 'B';
    else if (score>=70 && score<=79)
        return 'C';
    else if(score>=60 && score<=69)
        return 'D';
    else
        return 'F';
    }    // end letter grade method

    // Method to find students who need to retake exam
    public static String[] findFailingStudents(String[] names, int[] scores) {
    int failCount=0;
    for(int j=0; j<scores.length; j++){
        if(scores[j]<60)
            failCount++; //count n.o of fails to initialize the array of names
    }
    String[] failingStudents= new String[failCount]; //initialize array
        int k=0;
    for(int i=0; i<scores.length; i++){
        if(scores[i]<60){
            failingStudents[k++]=names[i];
        }
    } //end for loop
        return failingStudents;
    } //end method
    
}
