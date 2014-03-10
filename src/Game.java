/**
* Created with IntelliJ IDEA.
* User: fujunfeng
* Date: 14-3-10
* Time: 下午2:44
* To change this template use File | Settings | File Templates.
*/
public class Game {
    private int[] choseNum;
    private int[] guessNumber;
    private int bulls;
    private int cows;

    public Game(int[] choseNum, int... guessNumber) {
        this.choseNum = choseNum;
        this.guessNumber = guessNumber;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public Game run() {
        for (int i = 0; i < 4; i++) {
            if (guessNumber[i] == choseNum[i]) {
                bulls++;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (guessNumber[i] == choseNum[j]) {
                        cows++;
                    }
                }
            }
        }
        return this;
    }
}
