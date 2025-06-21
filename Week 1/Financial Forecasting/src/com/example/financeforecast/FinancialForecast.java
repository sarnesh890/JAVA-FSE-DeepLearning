package com.example.financeforecast;


public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return (1 + rate) * forecastFutureValue(presentValue, rate, years - 1);
        }
    }

    public static void main(String[] args) {
        double presentValue = 10000; // ₹10,000
        double growthRate = 0.08;    // 8% annual growth
        int years = 5;

        double futureValue = forecastFutureValue(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value after %d years: ₹%.2f%n", years, futureValue);
    }
}
