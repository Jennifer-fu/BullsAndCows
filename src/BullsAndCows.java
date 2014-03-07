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

    public static void main(String[] args){
        Random gen= new Random();
        int target= 0;

        String targetStr = target +"";
        boolean guessed = false;
        Scanner input = new Scanner(System.in);
        int guesses = 0;
        do{
            int bulls = 0;
            int cows = 0;
            System.out.print("Guess a 4-digit number with no duplicate digits: ");
            int guess;
            try{
                guess = input.nextInt();
                if(hasDupes(guess) || guess < 1000) continue;
            }catch(InputMismatchException e){
                continue;
            }
            guesses++;
            String guessStr = guess + "";
            for(int i= 0;i < 4;i++){
                if(guessStr.charAt(i) == targetStr.charAt(i)){
                    bulls++;
                }else if(targetStr.contains(guessStr.charAt(i)+"")){
                    cows++;
                }
            }
            if(bulls == 4){
                guessed = true;
            }else{
                System.out.println(cows+" Cows and "+bulls+" Bulls.");
            }
        }while(!guessed);
        System.out.println("You won after "+guesses+" guesses!");
    }

    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }
}
