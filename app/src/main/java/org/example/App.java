package org.example;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the payroll calculator, lets see what's left..");
        System.out.print("How many hours did you work this week? ");
        double hoursWorked = scanner.nextDouble();
        System.out.print("How many children do you have? ");
        int dependents = scanner.nextInt();
        double grossPay = PayrollCalculator.calculateGrossPay(hoursWorked);
        double totalDeductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        double netPay = PayrollCalculator.calculateNetPay(grossPay, totalDeductions);
        System.out.println("\nPayroll Stub:");
        System.out.printf("   Hours:   %.1f%n", hoursWorked);
        System.out.printf("    Rate:   %.2f $/hr%n", PayrollCalculator.HOURLY_RATE);
        System.out.printf("   Gross:   $ %.2f%n", grossPay);
        System.out.printf("\n  SocSec:   $ %.2f%n", grossPay * PayrollCalculator.SOC_SEC_TAX);
        System.out.printf("  FedTax:   $ %.2f%n", grossPay * PayrollCalculator.FEDERAL_TAX);
        System.out.printf("   StTax:   $ %.2f%n", grossPay * PayrollCalculator.STATE_TAX);
        System.out.printf("   Union:   $ %.2f%n", PayrollCalculator.UNION_DUES);
        System.out.printf("     Ins:   $ %.2f%n", (dependents >= 3) ? PayrollCalculator.INSURANCE_3_OR_MORE : PayrollCalculator.INSURANCE_UNDER_3);
        System.out.printf("\n     Net:   $ %.2f%n", netPay);
        System.out.println("\nFarewell and safe travels, friend.");
        scanner.close();
    }
}
