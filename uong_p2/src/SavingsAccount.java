import java.util.Scanner;

public class SavingsAccount {
    private static double annualInterestRate = 0;
    private double savingsBalance = 0.0;

    public void setSavingsBalance(double saverBalance){
        savingsBalance = saverBalance;
    }

    public void calculateMonthlyInterest(double saverBalance, double InterestRate) {
        savingsBalance = savingsBalance + ((saverBalance * InterestRate) / 12.0);

    }

    public void print() {
        System.out.printf("%.2f", savingsBalance);
    }

    public static double modifyInterestRate(double value){
        annualInterestRate = value;
        return annualInterestRate;
    }

}
