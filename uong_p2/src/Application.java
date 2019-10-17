public class Application {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        int i;
        double saver1Balance = 2000.00;
        double saver2Balance = 3000.00;
        double interestRate;

        interestRate = SavingsAccount.modifyInterestRate(0.04);

        saver1.setSavingsBalance(saver1Balance);
        saver2.setSavingsBalance(saver2Balance);

        System.out.println("Annual Interest Rate is set to 4%. ");

        System.out.print("\t\t\t" + "Saver 1");
        System.out.println("\t\t" + "Saver 2");

        for(i = 0; i < 12; ++i) {

            saver1.calculateMonthlyInterest(saver1Balance, interestRate);
            saver2.calculateMonthlyInterest(saver2Balance, interestRate);

            System.out.print("Month " + (i + 1) + " ");
            System.out.print("\t");
            saver1.print();
            System.out.print("\t\t");
            saver2.print();
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("Annual Interest Rate is set to 5%. ");

        interestRate = SavingsAccount.modifyInterestRate(0.05);


        System.out.print("\t\t\t" + "Saver 1");
        System.out.println("\t\t" + "Saver 2");

        for(i = 0; i < 12; ++i) {

            saver1.calculateMonthlyInterest(saver1Balance, interestRate);
            saver2.calculateMonthlyInterest(saver2Balance, interestRate);

            System.out.print("Month " + (i + 1) + " ");
            System.out.print("\t");
            saver1.print();
            System.out.print("\t\t");
            saver2.print();
            System.out.print("\n");
        }
    }

}
