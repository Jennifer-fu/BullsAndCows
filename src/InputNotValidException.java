/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-3-10
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public class InputNotValidException extends Throwable {
    private String message;

    public InputNotValidException(String error) {
        this.message = error;
    }

    public String getMessage(){
        return message;
    }
}
