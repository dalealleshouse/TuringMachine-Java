package test.com.hideoushumpbackfreak.turingmachine;

import com.hideioushumpbackfreak.turningmachine.Head;
import com.hideioushumpbackfreak.turningmachine.Machine;
import com.hideioushumpbackfreak.turningmachine.TransitionTableGenerator;
import org.junit.Test;

import static com.hideioushumpbackfreak.turningmachine.Head.BLANK_SYMBOL;
import static com.hideioushumpbackfreak.turningmachine.State.ERROR;
import static com.hideioushumpbackfreak.turningmachine.State.HALT;
import static org.junit.Assert.assertEquals;

public class MachineTest {
    @Test
    public void stepShouldGoIntoErrorStateIfNoMatchingTransitions() {
        Machine sut = new Machine(
                6,
                new Head(new char[]{'1', '1', '1'}, 1),
                TransitionTableGenerator.addition());

        Machine result = sut.step();
        assertEquals(ERROR, result.getState());
    }

    @Test
    public void stepShouldReturnThisIfHalted() {
        Machine sut = new Machine(
                HALT,
                new Head(new char[]{'1', '1', '1'}, 0),
                TransitionTableGenerator.addition());

        Machine result = sut.step();
        assertEquals(HALT, result.getState());
    }

    @Test
    public void stepShouldReturnThisIfError() {
        Machine sut = new Machine(
                ERROR,
                new Head(new char[]{'1', '1', '1'}, 0),
                TransitionTableGenerator.addition());

        Machine result = sut.step();
        assertEquals(ERROR, result.getState());
    }

    @Test
    public void stepShouldMakeTransition() {
        Machine sut = new Machine(
                0,
                new Head(new char[]{'1', '1', '1', BLANK_SYMBOL, '1', '1'}, 0),
                TransitionTableGenerator.addition());

        Machine result = sut.step();
        assertEquals(1, result.getState());
        assertEquals('1', result.getHead().read());
    }

    @Test
    public void stepShouldWriteTransition() {
        Machine sut = new Machine(
                3,
                new Head(new char[]{'1', '1', '1'}, 1),
                TransitionTableGenerator.addition());

        char result = sut.step().getHead().moveRight().read();
        assertEquals(BLANK_SYMBOL, result);
    }

    @Test
    public void runShouldAddTwoNumbers() {
        final String expected = "(_)11111__";
        Machine sut = new Machine(
                0,
                new Head(new char[]{'1', '1', '1', BLANK_SYMBOL, '1', '1'}, 0),
                TransitionTableGenerator.addition());

        Machine result = sut.run();
        assertEquals(expected, result.getHead().toString());
    }

    @Test
    public void runShouldMultiplyTwoNumbers() {
        final String expected = "______(_)111111";
        Machine sut = new Machine(
                0,
                new Head(new char[]{'1', '1', '1', BLANK_SYMBOL, '1', '1'}, 0),
                TransitionTableGenerator.Multiplication());

        Machine result = sut.run();
        assertEquals(expected, result.getHead().toString());
    }

    @Test
    public void runShouldReturnOnError() {
        final String expected = "(1)1_11";
        Machine sut = new Machine(
                6,
                new Head(new char[]{'1', '1', BLANK_SYMBOL, '1', '1'}, 0),
                TransitionTableGenerator.addition());

        Machine result = sut.run();
        assertEquals(expected, result.getHead().toString());
        assertEquals(ERROR, result.getState());
    }
}