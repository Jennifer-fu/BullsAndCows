import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-2-13
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class BullsAndCows {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random gen = new Random();
        for (int i = 0; i < 9; i++) {
            int j = gen.nextInt(9);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int[] choseNum = Arrays.copyOf(nums, 4);

        System.out.print("Guess a 4-digit number with no duplicate digits: ");
        boolean guess = false;

        do {
//            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("---");
            }
            char[] chars = input.toCharArray();
            int bulls = 0;
            int cows = 0;
            if (chars.length != 4) {
                System.out.println("Not a valid guess.");
            }
            for (int i = 0; i < 4; i++) {
                int curNum = chars[i] - 48;
                if (curNum > 9 || curNum < 1) {
                    System.out.println("Digit must be ge greater 0 and lower 10.");
                }
                if (curNum == choseNum[i]) {
                    bulls++;
                } else {
                    for (int j = 0; j < 4; j++) {
                        if (curNum == choseNum[j]) {
                            cows++;
                        }
                    }
                }
            }
            if (bulls == 4) {
                System.out.println("Congratulations! You have won!");
                guess = true;
            } else {
                System.out.println(String.format("Your Score is "+bulls+" bulls and "+cows+" cows"));
            }
        } while (!guess);
    }
}
