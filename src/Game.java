import java.util.*;

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
    private int[] answer;


    public Game(RandomNumberGenerator generator){
        this.answer = generator.run();
    }

    public boolean over() {
        return bulls == answer.length;
    }

    public String result() {
        return String.format("%dB%dC", this.bulls, this.cows);
    }

    public Game run(String input) throws InputNotValidException {
        int[] guessNumber = preProcess(input);
        calculateCount(guessNumber, answer);
        return this;
    }

    private void calculateCount(int[] guessNumber, int[] answer) {
        bulls = 0;
        cows = 0;
        for (int i = 0; i < answer.length; i++) {
            if (guessNumber[i] == answer[i]) {
                bulls++;
            } else {
                for (int j = 0; j < answer.length; j++) {
                    if (guessNumber[i] == answer[j]) {
                        cows++;
                    }
                }
            }
        }
    }

    private int[] preProcess(String input) throws InputNotValidException {
        char[] chars = input.toCharArray();

        checkLengthValid(chars);
        int[] guessNumber = changeToNumber(chars);
        checkDuplication(guessNumber);

        return guessNumber;
    }

    private void checkDuplication(int[] guessNumber) throws InputNotValidException {
        HashSet<Integer> inputNumbers = new HashSet<Integer>();
        for (int i = 0; i < answer.length; i++) {
            if (inputNumbers.contains(guessNumber[i])) {
                throw new InputNotValidException("Digit can not be duplicated.");
            }
            inputNumbers.add(guessNumber[i]);
        }
    }

    private int[] changeToNumber(char[] chars) throws InputNotValidException {
        int[] guessNumber = new int[answer.length];
        for (int i = 0; i < answer.length; i++) {
            int curNum = chars[i] - 48;
            if (curNum > 9 || curNum < 1) {
                throw new InputNotValidException("Digit must be a 4-digit number within 1 to 9.");
            }
            guessNumber[i] = curNum;
        }
        return guessNumber;
    }

    private void checkLengthValid(char[] chars) throws InputNotValidException {
        if (chars.length != answer.length) {
            throw new InputNotValidException("Digit must be a 4-digit number.");
        }
    }
}
