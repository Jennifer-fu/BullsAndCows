import com.sun.corba.se.impl.orb.ParserTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-3-10
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = new Game(4);
    }

    @Test
    public void should_return_4_bulls_and_0_cows_if_given_answer_is_1234_and_input_is_1234() {
        try {
            game.run("1234");
            assertThat(game.result(), is("4B0C"));
            assertThat(game.over(), is(true));
        } catch (InputNotValidException e) {
            fail();
        }
    }

    @Test
    public void should_return_0_bulls_and_0_cows_if_given_answer_is_1234_and_input_is_5678() {
        try {
            game.run("5678");
            assertThat(game.result(), is("0B0C"));
        } catch (InputNotValidException e) {
            fail();
        }
    }

    @Test
    public void should_return_1_bulls_and_2_cows_if_given_answer_is_1234_and_input_is_1425() {
        try {
            game.run("1425");
            assertThat(game.result(), is("1B2C"));
        } catch (InputNotValidException e) {
            fail();
        }
    }

    @Test
    public void should_throw_exception_when_input_number_not_in_1_to_9() {
        try {
            game.run("0123");
            fail();
        } catch (InputNotValidException e) {
            assertThat(e.getMessage(),is("Digit must be a 4-digit number within 1 to 9."));
        }
    }

    @Test
    public void should_throw_exception_when_input_number_more_than_4() {
        try {
            game.run("12345");
            fail();
        } catch (InputNotValidException e) {
            assertThat(e.getMessage(),is("Digit must be a 4-digit number."));
        }
    }

    @Test
    public void should_throw_exception_when_input_number_has_duplication() {
        try {
            game.run("1233");
            fail();
        } catch (InputNotValidException e) {
            assertThat(e.getMessage(),is("Digit can not be duplicated."));
        }
    }
}
