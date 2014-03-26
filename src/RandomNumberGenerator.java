import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-3-26
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class RandomNumberGenerator {
    private int length;

    public RandomNumberGenerator(int length){
        this.length = length;
    }

    public int[] run() {
        int[] validNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random gen = new Random();
        for (int i = 0; i < 9; i++) {
            int j = gen.nextInt(9);
            int temp = validNumbers[i];
            validNumbers[i] = validNumbers[j];
            validNumbers[j] = temp;
        }
        return Arrays.copyOf(validNumbers, length);
    }
}
