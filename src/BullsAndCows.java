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

    public static final int ANSWER_LENGTH = 4;

    public static void main(String[] args) {

        System.out.print("Guess a 4-digit number with no duplicate digits: ");
        boolean guess = false;
        Game game = new Game(new RandomNumberGenerator(ANSWER_LENGTH));

        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Please input a 4-digit number with no duplicate digits: ");
            }

            try {
                game.run(input);
            } catch (InputNotValidException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (game.over()) {
                System.out.println("Congratulations! You have won!");
                guess = true;
            } else {
                System.out.println("Your Score is: "+game.result());
            }
        } while (!guess);
    }

}
