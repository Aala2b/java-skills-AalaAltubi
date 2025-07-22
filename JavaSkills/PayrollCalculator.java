public class PayrollCalculator {
    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if(hoursWorked<0 || hourlyRate<0){
            System.out.println("invalid input: negative values.");
            return 0;
        switch (employeeType) {

    case "FULL_TIME":
        if(hoursWorked>40){
            return (40*hourlyRate) + (hourlyRate*1.5*(hoursWorked-40));
        }
        else {
           return hoursWorked*hourlyRate;
        }
        break;
    case "PART_TIME":
        if(hoursWorked>25){
            return hourlyRate*25;
        }
        else {
            return hourlyRate*hoursWorked;
        }
        break;
    case "CONTRACTOR":
        return hourlyRate*hoursWorked;
        break;
    case "INTERN":
        if(hoursWorked>20){
            return 0.8*hourlyRate*20;
        }
        else {
            return 0.8*hourlyRate*hoursWorked;
        }
        break;
    default:
        System.out.println("invalid employee type");
        return 0;
        break;

}
    }

    // Test data:
    String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN",
            "FULL_TIME"};
    double[] hours = {45, 20, 35, 15, 50};
    double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
    String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
}
