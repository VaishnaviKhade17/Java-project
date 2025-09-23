import java.util.*;

public class LotteryGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lottery = (int)(Math.random() * 90 + 10); // random 2-digit number
        System.out.print("Enter a two-digit number: ");
        int guess = sc.nextInt();

        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("Lottery number: " + lottery);

        if (guess == lottery) {
            System.out.println("Exact match! You win $10,000");
        } else if (guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1) {
            System.out.println("All digits match! You win $3,000");
        } else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2
                || guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2) {
            System.out.println("One digit matches! You win $1,000");
        } else {
            System.out.println("Sorry, no match.");
        }
    }
}
