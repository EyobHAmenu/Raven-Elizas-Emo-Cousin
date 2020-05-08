import java.util.Scanner;

public class RavenInvoice {
    public static void main(String[] args) {

        String userInput = " ";
        String userInputArr[];
        int userPositiveWords;
        int userNegativeWords;

        Scanner in = new Scanner(System.in);
        Person newPerson = new Person();

        System.out.println("******** Welcome to Raven Counseling *******");
        System.out.println("Please answer some question before the counseling.");
        System.out.print("Enter your full name please: ");
        newPerson.setName(in.nextLine());
        System.out.print("Enter address: ");
        newPerson.setAddress(in.nextLine());
        System.out.print("Enter your city: ");
        newPerson.setCity(in.nextLine());
        System.out.print("Enter your state in two letters please: ");
        newPerson.setState(in.nextLine());
        System.out.print("Enter your Zipcode: ");
        newPerson.setZip(in.nextInt());
        in.nextLine();
        while (!(userInput.equalsIgnoreCase("Q"))) {
            newPerson.setSession(newPerson.getSession());
            System.out.println("Hello " + newPerson.getName() + ". My name is Eyob. Am your doctor for today.\n"
                    + "How are you feeling today?");
            userInput = in.nextLine();
            while (!(userInput.equalsIgnoreCase("Q"))) {
                newPerson.setQuestions(newPerson.getQuestions());
                userInputArr = userInput.split(" ");
                userPositiveWords = newPerson.positiveCounter(userInputArr);
                userNegativeWords = newPerson.negativeCounter(userInputArr);
                if (userPositiveWords > userNegativeWords) {
                    System.out.println("Am so happy for you.");
                    System.out.println("Anything you want to tell or ask me (Q to end)?");
                    userInput = in.nextLine();
                }
                else if (userNegativeWords > userPositiveWords) {
                    for (String userWord : userInputArr) {
                        if (userWord.equalsIgnoreCase("i")) {
                            userWord = "you";
                        } else if (userWord.equalsIgnoreCase("me")) {
                            userWord = "you";
                        }else if (userWord.equalsIgnoreCase("my")) {
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

        newPerson.bill();
        System.out.println("Thank you for the chat. Have a wonderful day.");
    }
}
