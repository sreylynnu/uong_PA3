import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class ArithmeticStudy {
    //A method is used to generate the response.
    public static void generateResponse(int reply) {

        //Displays the proper response message based on whether the student's answer is correct or not.
        switch(reply) {
            case 0:
                System.out.println("Wrong answer.");
                break;

            case 1:
                System.out.println("Right answer.");
                break;

            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    //A method is used to generate the questions.
    public static int generateQuestions(int difficultyLevel, int problemType, int rangeFirst){

        Scanner scnr = new Scanner(System.in);
        SecureRandom random = new SecureRandom(); //A SecureRandom object is used to generate random number.

        int i;
        int random_Int1;
        int random_Int2;
        int random_ProblemType;
        int correct = 0;
        int reply;
        int mixture = 0;

        double studentResponse; //Student's response is stored in a double precision floating-point variable.
        double answer;

    /*
      Runs the user through 10 randomly generated questions per session.
      Prompts the student for the answer.
    */
        for(i = 0; i < 10; ++i){

            random_ProblemType = random.nextInt(4) + 1;

            if(problemType == 5) {
                mixture = random_ProblemType;
            }

            if(problemType == 1 || mixture == 1) {
                random_Int1 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                random_Int2 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;


                System.out.println("What is " + random_Int1 + " plus " + random_Int2 + "?");
                studentResponse = scnr.nextDouble();

                answer = random_Int1 + random_Int2;

                //Program uses floating-point comparison to determine if the student's answer is correct.
                if(Math.abs(studentResponse - answer) < 0.0001){
                    reply = 1;
                    correct++;
                    generateResponse(1);
                }
                else {
                    reply = 0;
                    generateResponse(0);
                }
            }
            else if(problemType == 2 || mixture == 2) {
                random_Int1 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                random_Int2 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                System.out.println("What is " + random_Int1 + " times " + random_Int2 + "?");
                studentResponse = scnr.nextDouble();

                answer = random_Int1 * random_Int2;

                if(Math.abs(studentResponse - answer) < 0.0001){
                    reply = 1;
                    correct++;
                    generateResponse(1);
                }
                else {
                    reply = 0;
                    generateResponse(0);
                }
            }
            else if(problemType == 3 || mixture == 3) {
                random_Int1 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                random_Int2 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                System.out.println("What is " + random_Int1 + " minus " + random_Int2 + "?");
                studentResponse = scnr.nextDouble();

                answer = random_Int1 - random_Int2;

                if(Math.abs(studentResponse - answer) < 0.000001){
                    reply = 1;
                    correct++;
                    generateResponse(1);
                }
                else {
                    reply = 0;
                    generateResponse(0);
                }
            }
            else if(problemType == 4 || mixture == 4) {
                random_Int1 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                random_Int2 = random.nextInt(difficultyLevel - rangeFirst) + rangeFirst;
                System.out.println("What is " + random_Int1 + " divided by " + random_Int2 + "?");
                studentResponse = scnr.nextDouble();

                answer = random_Int1 / random_Int2;

                if(Math.abs(studentResponse - answer) < 0.0001){
                    reply = 1;
                    correct++;
                    generateResponse(1);
                }
                else {
                    reply = 0;
                    generateResponse(0);
                }
            }
        }
        return correct;
    }

    //A method is used to print the arithmetic problem types.
    private static void printProblemType(){
        System.out.println("Please pick a type of arithmetic problem to study: ");
        System.out.println("Enter 1 for addition problems only.");
        System.out.println("Enter 2 for multiplication problems only.");
        System.out.println("Enter 3 for subtraction problems only.");
        System.out.println("Enter 4 for division problems only.");
        System.out.println("Enter 5 for a random mixture of all these types.");
    }

    //A method is used to determine the problem type.
    public static int problemType(int userProblemType){
        return userProblemType;
    }

    //A method is used to determine the difficulty level.
    public static int difficultyLevel(int userDifficulty) {
        int range = 0;

        if(userDifficulty == 1) {
            range = 10;
        }
        else if(userDifficulty == 2) {
            range = 100;
        }
        else if(userDifficulty == 3) {

            range = 1000;
        }
        else if(userDifficulty == 4){
            range = 10000;
        }
        return range;
    }

    public static int rangeFirst(int userDifficulty) {
        int rangeFirst = 0;

        if(userDifficulty == 1) {
            rangeFirst = 1;
        }
        else if(userDifficulty == 2) {
            rangeFirst = 10;
        }
        else if(userDifficulty == 3) {

            rangeFirst = 100;
        }
        else if(userDifficulty == 4){
            rangeFirst = 1000;
        }
        return rangeFirst;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int userDifficulty;
        int range;
        int rangeFirstNum;
        int correctAnswers;
        int userProblemType;
        double percentage;
        int reset;

        do {
            //Student is first prompted for a difficulty level when starting a session.
            System.out.print("Please enter a difficulty level (1-4): ");
            do {
                userDifficulty = scnr.nextInt();
            }
            while (userDifficulty < 1 || userDifficulty > 4);

            range = difficultyLevel(userDifficulty);
            rangeFirstNum = rangeFirst(userDifficulty);

            //After difficulty level, the student is then prompted for the problem type to be studied.
            printProblemType();
            do {
                userProblemType = scnr.nextInt();
            }
            while (userProblemType < 1 || userProblemType > 5);

            correctAnswers = generateQuestions(range, userProblemType, rangeFirstNum);

            //Displays the number of correct and incorrect responses at the end of each session.
            System.out.print("\n");
            System.out.println("RESULTS:");
            System.out.println("Correct: " + correctAnswers);
            System.out.println("Incorrect: " + (10 - correctAnswers));

            percentage = ((double) (correctAnswers) / 10.0);

            System.out.println("Percentage: " + (percentage * 100) + "%");

        /*Displays a message indicating whether or not the student is ready to advance at the end of a session.
          Also asks the user if they wish to begin a new session.
        */
            if (percentage < 0.75) {

                System.out.println("Please ask your teacher for extra help.");
                System.out.println("Would you like to begin a new session? ");
                System.out.println("Enter 1 to begin a new session or 0 to exit.");

                do{
                    reset = scnr.nextInt();
                }
                while(reset < 0 || reset > 1);

                if(reset == 0){
                    break;
                }

            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
                System.out.println("Would you like to begin a new session? ");
                System.out.println("Enter 1 to begin a new session or 0 to exit.");

                do{
                    reset = scnr.nextInt();
                }
                while(reset < 0 || reset > 1);

                if(reset == 0){
                    break;
                }
            }
        }
        while(reset != 0);

        System.out.println("Goodbye!");

    }
}
