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
    private int bulls;
    private int cows;
    private int answerLength;

    public Game(int answerLength){
        this.answerLength = answerLength;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public Game run(String input) throws InputNotValidException {
        int[] guessNumber = preProcess(input);
        int[] answer = generateAnswer();
        calculateCount(guessNumber, answer);
        return this;
    }

    private void calculateCount(int[] guessNumber, int[] answer) {
        for (int i = 0; i < answerLength; i++) {
            if (guessNumber[i] == answer[i]) {
                bulls++;
            } else {
                for (int j = 0; j < answerLength; j++) {
                    if (guessNumber[i] == answer[j]) {
                        cows++;
                    }
                }
            }
        }
    }

    private int[] preProcess(String input) throws InputNotValidException {
        char[] chars = input.toCharArray();
        if (chars.length != answerLength) {
            throw new InputNotValidException("Digit must be a 4-digit number.");
        }

        int[] guessNumber = new int[answerLength];
        for (int i = 0; i < answerLength; i++) {
            int curNum = chars[i] - 48;
            if (curNum > 9 || curNum < 1) {
                throw new InputNotValidException("Digit must be a 4-digit number within 1 to 9.");
            }
            guessNumber[i] = curNum;
        }
        return guessNumber;
    }

    private int[] generateAnswer() {
        int[] validNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random gen = new Random();
        for (int i = 0; i < 9; i++) {
            int j = gen.nextInt(9);
            int temp = validNumbers[i];
            validNumbers[i] = validNumbers[j];
            validNumbers[j] = temp;
        }
        return Arrays.copyOf(validNumbers, answerLength);
    }
}
