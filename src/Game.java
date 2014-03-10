import java.util.Arrays;
import java.util.Random;

/**
* Created with IntelliJ IDEA.
* User: fujunfeng
* Date: 14-3-10
* Time: 下午2:44
* To change this template use File | Settings | File Templates.
*/
public class Game {
    private int[] guessNumber;
    private int bulls;
    private int cows;

    public Game(int... guessNumber) {
        this.guessNumber = guessNumber;
    }

    private int[] generateAnswer() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random gen = new Random();
        for (int i = 0; i < 9; i++) {
            int j = gen.nextInt(9);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return Arrays.copyOf(nums, 4);
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public Game run() {
        int[] answer = generateAnswer();
        for (int i = 0; i < 4; i++) {
            if (guessNumber[i] == answer[i]) {
                bulls++;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (guessNumber[i] == answer[j]) {
                        cows++;
                    }
                }
            }
        }
        return this;
    }
}
