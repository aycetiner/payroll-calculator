/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayrollCalculatorAppAYC;

//Ali Yener Cetiner
//12.06.2020
// PayrollCalculatorAppAYC.java - This program calculates payroll./ 

// Import java.util.Scanner and java.text.DecimalFormat/ 
import java.util.Scanner;
import java.text.DecimalFormat;

public class PayrollCalculatorAppAYC
 
{
    public static void main(String args[])
    {
        // Construct Scanner and DecimalFormat.
        Scanner s = new Scanner(System.in);
        DecimalFormat currency = new DecimalFormat("$#,###.00");
                
        // Declare and initialize variables and constants here.
        final String WELCOME_MESSAGE = "Welcome to Payroll Calculator App!\n";
        double salary = 0; 
 	double numDependents = 0; 
 	double stateTax;
        double federalTax;
        double dependentDeduction;
        double totalWithholding;
        double takeHomePay;
        String enterAnother = "Y";
        
        System.out.println(WELCOME_MESSAGE); 
        
        while (enterAnother.equalsIgnoreCase("Y")){
               
            // This is the work done in the housekeeping() method
            System.out.println("Enter salary: ");
            salary = s.nextDouble();
        
            while(salary <= 0 || salary >300000){
            System.out.println("Salary entered is invalid. Please enter salary(between 0 and 300000): ");
            salary = s.nextDouble();
            }
        
            System.out.println("Enter number of dependents: ");
            numDependents = s.nextDouble();
        
            while(numDependents <= 0 || numDependents >20){
            System.out.println("Number of dependents entered is invalid. Please enter number of dependents(between 0 and 20): ");
            numDependents = s.nextDouble();
            }
        
            // The logic is written here.
            stateTax = salary * .065;
            federalTax = salary * .28;
            dependentDeduction = (salary * .025)* numDependents;
            totalWithholding = stateTax + federalTax;
            takeHomePay = salary - totalWithholding + dependentDeduction;
        
            //Output statement
            System.out.print("\n\nState Tax:\t\t" + currency.format(stateTax)+ "\n");
            System.out.print("Federal Tax:\t\t" + currency.format(federalTax) + "\n");
            System.out.print("Dependent Deduction:\t" + currency.format(dependentDeduction)+ "\n");
            System.out.print("Salary:\t\t\t" + currency.format(salary)+"\n");
            System.out.print("Take Home Pay:\t\t" + currency.format(takeHomePay)+ "\n");
        
            System.out.println("Would you like to enter for another employee? (y/n): ");
            enterAnother = s.next();
            
            while(!enterAnother.equalsIgnoreCase("Y") && !enterAnother.equalsIgnoreCase("N")){
            System.out.println("Error - Please enter 'y' or 'n': ");
            enterAnother = s.next();
            } 
        }            
        System.exit(0);
    }
}   


