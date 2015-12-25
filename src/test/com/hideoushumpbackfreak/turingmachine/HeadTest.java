package test.com.hideoushumpbackfreak.turingmachine;

import com.hideioushumpbackfreak.turningmachine.Head;
import com.hideioushumpbackfreak.turningmachine.HeadDirection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void constructorShouldThrowIfHeadPositionIsHigherThanArrayLength() {
        new Head(new char[]{'a', 'b'}, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void constructorShouldThrowIfHeadPositionIsNegative() {
        new Head(new char[]{'a', 'b'}, 3);
    }

    @Test
    public void readShouldReturnTapeHead() {
        final char expected = 'b';
        final char[] data = new char[]{'a', 'b', 'c'};

        Head sut = new Head(data, 1);
        char result = sut.read();
        assertEquals(expected, result);
    }

    @Test
    public void writeShouldReturnNewTapeWithUpdatedHead() {
        final String expected = "a(f)c";
        final char[] data = new char[]{'a', 'b', 'c'};

        Head sut = new Head(data, 1);
        Head result = sut.write('f');
        assertEquals(expected, result.toString());
    }

    @Test
    public void writeShouldNotMutateOriginalData() {
        final String expected = "a(b)c";
        final char[] data = new char[]{'a', 'b', 'c'};

        Head sut = new Head(data, 1);
        sut.write('f');
        assertEquals(expected, sut.toString());
    }

    @Test
    public void moveLeftShouldMoveWhenAtZeroHeadPosition() {
        final String expected = "(_)abcd";
        Head sut = new Head(new char[]{'a', 'b', 'c', 'd'}, 0);
        Head result = sut.moveLeft();
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveLeftShouldMoveToTheLeft() {
        final char[] data = new char[]{'a', 'b', 'c', 'd', 'e'};

        String expected = "ab(c)de";
        Head sut = new Head(data, 3);
        Head result = sut.moveLeft();
        assertEquals(expected, result.toString());

        expected = "abc(d)e";
        sut = new Head(data, 4);
        result = sut.moveLeft();
        assertEquals(expected, result.toString());

        expected = "(a)bcde";
        sut = new Head(data, 1);
        result = sut.moveLeft();
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveRightShouldMoveRightWhenAtLastHeadPosition() {
        final String expected = "abcd(_)";
        Head sut = new Head(new char[]{'a', 'b', 'c', 'd'}, 3);
        Head result = sut.moveRight();
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveRightMoveToTheRight() {
        final char[] data = new char[]{'a', 'b', 'c', 'd', 'e'};

        String expected = "abcd(e)";
        Head sut = new Head(data, 3);
        Head result = sut.moveRight();
        assertEquals(expected, result.toString());

        expected = "a(b)cde";
        sut = new Head(data, 0);
        result = sut.moveRight();
        assertEquals(expected, result.toString());

        expected = "ab(c)de";
        sut = new Head(data, 1);
        result = sut.moveRight();
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveShouldMoveHeadLeftWithLeftDirection() {
        final char[] data = new char[]{'a', 'b', 'c', 'd', 'e'};
        final String expected = "ab(c)de";

        Head sut = new Head(data, 3);
        Head result = sut.move(HeadDirection.Left);
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveShouldMoveHeadRightWithRightDirection() {
        final char[] data = new char[]{'a', 'b', 'c', 'd', 'e'};
        final String expected = "ab(c)de";
        Head sut = new Head(data, 1);
        Head result = sut.move(HeadDirection.Right);
        assertEquals(expected, result.toString());
    }

    @Test
    public void moveShouldNotMoveWithNoMove() {
        final char[] data = new char[]{'a', 'b', 'c', 'd', 'e'};
        final String expected = "ab(c)de";
        Head sut = new Head(data, 2);
        Head result = sut.move(HeadDirection.NoMove);
        assertEquals(expected, result.toString());
    }

    @Test
    public void toStringShouldPrintOutTape() {
        char[] data = new char[]{'a', 'b', 'c', 'd', 'c', 'b', 'a'};

        String expected = "abc(d)cba";
        Head sut = new Head(data, 3);
        assertEquals(expected, sut.toString());

        expected = "(a)bcdcba";
        sut = new Head(data, 0);
        assertEquals(expected, sut.toString());

        expected = "abcdcb(a)";
        sut = new Head(data, 6);
        assertEquals(expected, sut.toString());
    }
}