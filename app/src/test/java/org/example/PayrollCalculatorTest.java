package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

  public class PayrollCalculatorTest {
      @Test
      public void testGrossPayUnder40Hours() {
          assertEquals(335.60, PayrollCalculator.calculateGrossPay(20), 0.01);
          assertEquals(671.20, PayrollCalculator.calculateGrossPay(40), 0.01);
      }
      @Test
      public void testGrossPayOver40Hours() {
          assertEquals(696.37, PayrollCalculator.calculateGrossPay(41), 0.01);
          assertEquals(721.54, PayrollCalculator.calculateGrossPay(42), 0.01);
      }
      @Test
      public void testDeductionsWithFewDependents() {
          double grossPay = PayrollCalculator.calculateGrossPay(40);
          double expectedDeductions = (grossPay * 0.06) + (grossPay * 0.14) + (grossPay * 0.05) + 10 + 15;
          assertEquals(expectedDeductions, PayrollCalculator.calculateDeductions(grossPay, 2), 0.01);
      }
      @Test
      public void testDeductionsWithThreeOrMoreDependents() {
          double grossPay = PayrollCalculator.calculateGrossPay(40);
          double expectedDeductions = (grossPay * 0.06) + (grossPay * 0.14) + (grossPay * 0.05) + 10 + 35;
          assertEquals(expectedDeductions, PayrollCalculator.calculateDeductions(grossPay, 3), 0.01);
      }
      @Test
      public void testNetPayCalculation() {
          double grossPay = PayrollCalculator.calculateGrossPay(40);
          double deductions = PayrollCalculator.calculateDeductions(grossPay, 2);
          double expectedNetPay = grossPay - deductions;
          assertEquals(expectedNetPay, PayrollCalculator.calculateNetPay(grossPay, deductions), 0.01);
      }
      @Test
      public void testNetPayWithOvertime() {
          double grossPay = PayrollCalculator.calculateGrossPay(45);
          double deductions = PayrollCalculator.calculateDeductions(grossPay, 4);
          double expectedNetPay = grossPay - deductions;
          assertEquals(expectedNetPay, PayrollCalculator.calculateNetPay(grossPay, deductions), 0.01);
      }
  } 
