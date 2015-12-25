package test.com.hideoushumpbackfreak.turingmachine;

import com.hideioushumpbackfreak.turningmachine.Head;
import org.junit.Test;

public class HeadTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void ctorShouldThrowIfHeadPositionIsHigherThanArrayLength() {
        new Head(new char[]{'a', 'b'}, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ctorShouldThrowIfHeadPositionIsNegative() {
        new Head(new char[]{'a', 'b'}, 3);
    }
}