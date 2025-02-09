package org.example;

public class PayrollCalculator {
    public static final double HOURLY_RATE = 16.78;
    public static final double OVERTIME_RATE = HOURLY_RATE * 1.5;
    public static final int REGULAR_HOURS = 40;
    public static final double SOC_SEC_TAX = 0.06;
    public static final double FEDERAL_TAX = 0.14;
    public static final double STATE_TAX = 0.05;
    public static final double UNION_DUES = 10.00;
    public static final double INSURANCE_UNDER_3 = 15.00;
    public static final double INSURANCE_3_OR_MORE = 35.00;

    public static double calculateGrossPay(double hoursWorked) {
        if (hoursWorked <= REGULAR_HOURS) {
            return hoursWorked * HOURLY_RATE;
        } else {
            return (REGULAR_HOURS * HOURLY_RATE) + ((hoursWorked - REGULAR_HOURS) * OVERTIME_RATE);
        }
    }

    public static double calculateDeductions(double grossPay, int dependents) {
        double socialSecurity = grossPay * SOC_SEC_TAX;
        double federalTax = grossPay * FEDERAL_TAX;
        double stateTax = grossPay * STATE_TAX;
        double insurance = (dependents >= 3) ? INSURANCE_3_OR_MORE : INSURANCE_UNDER_3;
        return socialSecurity + federalTax + stateTax + UNION_DUES + insurance;
    }

    public static double calculateNetPay(double grossPay, double deductions) {
        return grossPay - deductions;
    }
}