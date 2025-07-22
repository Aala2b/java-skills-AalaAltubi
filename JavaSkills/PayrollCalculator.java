public class PayrollCalculator {
    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if(hoursWorked<0 || hourlyRate<0) {
            System.out.println("invalid input: negative values.");
            return 0;
        }
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
    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance){
        double tax;
        if(grossPay<0)
            System.out.println("invalid input, negative value");
        else if(grossPay<=500)
            tax=0.1*grossPay;
        else if(grossPay>=501 && grossPay<=1000)
            tax=0.15*grossPay;
        else if(grossPay>=1001 && grossPay<=2000)
            tax=0.2*grossPay;
        else
            tax=0.25*grossPay;
        if(hasHealthInsurance){
             tax-=50;
            if (tax < 0)
                tax = 0;
        }
        return tax;

    }
    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names){
       double[] netPays= new double[4]; //declare array for payroll
        double totalPay=0; //initialize before summing, used to calculate avg
        double highestPay = Double.MIN_VALUE; //compare and update this value whenever we find a higher net pay.
        double lowestPay = Double.MAX_VALUE;  //if we find any employee with a lower pay we update this.
        String highestPaidEmployee = "", lowestPaidEmployee = "";
        int overtimeCount = 0;
        for (int i=0; i<4; i++){
            double gross= calculateWeeklyPay(employeeTypes[i],hours[i], rates[i]);
            double tax=calculateTaxDeduction(gross,true);
            double pay= gross-tax;
            netPays[i]=pay;
            totalPay+=pay;

            if(pay>highestPay){
                highestPay=pay;
                highestPaidEmployee=names[i];
            }
            if(pay<lowestPay){
                lowestPay=pay;
                lowestPaidEmployee=names[i];
            }
            if(hours[i]>40)
                overtimeCount++;
            //display results
            System.out.printf("%-10s %-12s %-10.1f %-10.2f %-10.2f %-10.2f%n", names[i], employeeTypes[i], hours[i], gross, tax, pay);

        } //end of for loop

        //display payroll summary
        System.out.println("\n--- Payroll Summary ---");
        System.out.printf("Highest Paid Employee : %s (%.2f)%n", highestPaidEmployee, highestPay);
        System.out.printf("Lowest Paid Employee  : %s (%.2f)%n", lowestPaidEmployee, lowestPay);
        System.out.printf("Average Net Pay       : %.2f%n", totalPay /5);
        System.out.printf("Employees with Overtime: %d%n", overtimeCount);

    }

    public static void main(String[] args) {
        // Test data:
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
    processPayroll(types, hours, rates, names); //process all payrolls
    }
    }
