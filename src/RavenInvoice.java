import java.util.Scanner;

public class RavenInvoice {
    public static void main(String[] args) {
        /*
            Sample case:
            ******** Welcome to Raven Counseling *******
            Please answer some question before the counseling.
            Enter your full name please: Eyob Amenu
            Enter address: 1234 Java Ave
            Enter your city: Silver Spring
            Enter your state in two letters please: MD
            Enter your Zipcode: 20909
            Hello Eyob Amenu. My name is Eyob. Am your doctor for today.
            How are you feeling today?
            happy
            Am so happy for you.
            Anything you want to tell or ask me (Q to end)?
            sad
            Really! Why you said sad
            sad and happy
            I do not get it. Can you tell me more please! (Q to end)
            q
            Do you need another session (Q to end) ?yes
            Hello Eyob Amenu. My name is Eyob. Am your doctor for today.
            How are you feeling today?
            hello
            I do not get it. Can you tell me more please! (Q to end)
            am good
            Am so happy for you.
            Anything you want to tell or ask me (Q to end)?
            q
            Do you need another session (Q to end) ?q
            **************************************
            Raven's Invoice
            To:Eyob Amenu
            1234 Java Ave
            Silver Spring, MD 20909

            Items:
            Quantity    Description   Price   Total
               2            Session     100.00    200.00
               5          Questions       0.35      1.75
            Total Due: 201.75
            Thank you for the chat. Have a wonderful day.
         */


        String userInput = " ";
        String userInputArr[];
        int userPositiveWords;
        int userNegativeWords;

        Scanner in = new Scanner(System.in);
        Invoice newCustomer = new Invoice();

        System.out.println("******** Welcome to Raven Counseling *******");
        System.out.println("Please answer some question before the counseling.");
        System.out.print("Enter your full name please: ");
        newCustomer.setName(in.nextLine());
        System.out.print("Enter address: ");
        newCustomer.setAddress(in.nextLine());
        System.out.print("Enter your city: ");
        newCustomer.setCity(in.nextLine());
        System.out.print("Enter your state in two letters please: ");
        newCustomer.setState(in.nextLine());
        System.out.print("Enter your Zipcode: ");
        newCustomer.setZip(in.nextInt());
        in.nextLine();
        while (!(userInput.equalsIgnoreCase("Q"))) {
            newCustomer.setSession(newCustomer.getSession());
            System.out.println("Hello " + newCustomer.getName() + ". My name is Eyob. Am your doctor for today.\n"
                    + "How are you feeling today?");
            userInput = in.nextLine();
            while (!(userInput.equalsIgnoreCase("Q"))) {
                newCustomer.setQuestions(newCustomer.getQuestions());
                userInputArr = userInput.split(" ");
                userPositiveWords = positiveCounter(userInputArr);
                userNegativeWords = negativeCounter(userInputArr);
                if (userPositiveWords > userNegativeWords) {
                    System.out.println("Am so happy for you.");
                    System.out.println("Anything you want to tell or ask me (Q to end)?");
                    userInput = in.nextLine();
                } else if (userNegativeWords > userPositiveWords) {
                    for (String userWord : userInputArr) {
                        if (userWord.equalsIgnoreCase("i")) {
                            userWord = "you";
                        } else if (userWord.equalsIgnoreCase("me"))
                            userWord = "you";
                        else if (userWord.equalsIgnoreCase("my")) {
                            userWord = "your";
                        } else if (userWord.equalsIgnoreCase("am")) {
                            userWord = "are";
                        }
                    }
                    System.out.print("Really! Why you said ");
                    for (String userWord : userInputArr) {
                        System.out.print(userWord + " ");
                    }
                    System.out.println();
                    userInput = in.nextLine();
                }
                else {
                    System.out.println("I do not get it. Can you tell me more please! (Q to end)");
                    userInput = in.nextLine();
                }
            }
            System.out.print("Do you need another session (Q to end) ?");
            userInput = in.nextLine();
        }


        newCustomer.bill();
        System.out.println("Thank you for the chat. Have a wonderful day.");

    }
    public static int positiveCounter(String [] arr){
        String [] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        int positiveWords = 0;
        for(String x : arr){
            for(String p : positive){
                if(x.equalsIgnoreCase(p)){
                    positiveWords++;
                }
            }
        }
        return positiveWords;
    }

    public static int negativeCounter(String [] arr){
        String [] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
        int negativeWords = 0;
        for(String x : arr){
            for(String n : negative){
                if(x.equalsIgnoreCase(n)){
                    negativeWords++;
                }
            }
        }
        return negativeWords;
    }
}
