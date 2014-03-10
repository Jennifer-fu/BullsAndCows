import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-2-13
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class BullsAndCows {

    public static void main(String[] args) {

        System.out.print("Guess a 4-digit number with no duplicate digits: ");
        boolean guess = false;

        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Please input a 4-digit number with no duplicate digits: ");
            }
            char[] chars = input.toCharArray();
            if (chars.length != 4) {
                System.out.println("Digit must be a 4-digit number.");
                continue;
            }

            int[] guessNumber = new int[4];
            for (int i = 0; i < 4; i++) {
                int curNum = chars[i] - 48;
                if (curNum > 9 || curNum < 1) {
                    System.out.println("Digit must be a 4-digit number within 1 to 9.");
                    break;
                }
                guessNumber[i] = curNum;
            }

            if (guessNumber[3] == 0) {
                continue;
            }
            Game game = new Game(guessNumber).run();
            int bulls = game.getBulls();
            int cows = game.getCows();
            if (bulls == 4) {
                System.out.println("Congratulations! You have won!");
                guess = true;
            } else {
                System.out.println("Your Score is " + bulls + " bulls and " + cows + " cows");
            }
        } while (!guess);
    }

}
