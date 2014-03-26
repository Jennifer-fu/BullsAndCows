import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: fujunfeng
 * Date: 14-3-26
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class RandomNumberGeneratorTest {

    @Test
    public void should_generator_4_number_without_duplication(){
        RandomNumberGenerator generator = new RandomNumberGenerator(4);
        int[] result = generator.run();
        assertThat(result.length, is(4));
        assertWithoutDuplication(result);
    }

    private void assertWithoutDuplication(int[] result) {
        List<int[]> list = Arrays.asList(result);
        assertThat(list.lastIndexOf(result[0])==list.indexOf(result[0]),is(true));
        assertThat(list.lastIndexOf(result[1])==list.indexOf(result[1]),is(true));
        assertThat(list.lastIndexOf(result[2])==list.indexOf(result[2]),is(true));
        assertThat(list.lastIndexOf(result[3])==list.indexOf(result[3]),is(true));
    }
}
