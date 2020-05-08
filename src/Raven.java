import java.util.Scanner;

public class Raven {
    public static void main(String[] args) {

        String userInput;
        String userInputArr [];
        int userPositiveWords;
        int userNegativeWords;

        Scanner in = new Scanner(System.in);
        System.out.println("Good morning. How are you feeling today?");
        userInput = in.nextLine();
        while (!(userInput.equalsIgnoreCase("Q"))){
            userInputArr = userInput.split(" ");
            userPositiveWords = positiveCounter(userInputArr);
            userNegativeWords = negativeCounter(userInputArr);
            if (userPositiveWords > userNegativeWords){
                System.out.println("Am so happy for you.");
                System.out.println("Anything you want to tell me ?");
                userInput = in.nextLine();
            }
            else if(userNegativeWords > userPositiveWords){
                for(String userWord : userInputArr){
                    if(userWord.equalsIgnoreCase("i")){
                        userWord = "you";
                    }
                    else if(userWord.equalsIgnoreCase("me"))
                        userWord = "you";
                    else if(userWord.equalsIgnoreCase("my")) {
                        userWord = "your";
                    }
                    else if(userWord.equalsIgnoreCase("am")){
                        userWord = "are";
                    }
                }
                System.out.print("Really! Why you said ");
                for(String userWord : userInputArr){
                    System.out.print(userWord + " ");
                }
                System.out.println();
                userInput = in.nextLine();
            }
            else{
                System.out.println("I do not get it. Can you tell me more please!");
                userInput = in.nextLine();
            }
        }
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
