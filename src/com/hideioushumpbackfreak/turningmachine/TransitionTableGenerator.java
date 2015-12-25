package com.hideioushumpbackfreak.turningmachine;

import java.util.Arrays;
import java.util.List;

import static com.hideioushumpbackfreak.turningmachine.Head.BLANK_SYMBOL;

public class TransitionTableGenerator {
    public static List<Transition> addition() {
        return Arrays.asList(
                new Transition(0, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 0),
                new Transition(0, '1', '1', HeadDirection.Right, 1),
                new Transition(1, BLANK_SYMBOL, '1', HeadDirection.Right, 2),
                new Transition(1, '1', '1', HeadDirection.Right, 1),
                new Transition(2, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 3),
                new Transition(2, '1', '1', HeadDirection.Right, 2),
                new Transition(3, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 3),
                new Transition(3, '1', BLANK_SYMBOL, HeadDirection.Left, 4),
                new Transition(4, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.NoMove, State.HALT),
                new Transition(4, '1', '1', HeadDirection.Left, 4)
        );
    }

    public static List<Transition> Multiplication() {
        return Arrays.asList(
                new Transition(0, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 1),
                new Transition(0, '1', BLANK_SYMBOL, HeadDirection.Right, 2),
                new Transition(1, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 14),
                new Transition(1, '1', BLANK_SYMBOL, HeadDirection.Right, 2),
                new Transition(2, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 3),
                new Transition(2, '1', '1', HeadDirection.Right, 2),
                new Transition(3, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 15),
                new Transition(3, '1', BLANK_SYMBOL, HeadDirection.Right, 4),
                new Transition(4, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 5),
                new Transition(4, '1', '1', HeadDirection.Right, 4),
                new Transition(5, BLANK_SYMBOL, '1', HeadDirection.Left, 6),
                new Transition(5, '1', '1', HeadDirection.Right, 5),
                new Transition(6, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 7),
                new Transition(6, '1', '1', HeadDirection.Left, 6),
                new Transition(7, BLANK_SYMBOL, '1', HeadDirection.Left, 9),
                new Transition(7, '1', '1', HeadDirection.Left, 8),
                new Transition(8, BLANK_SYMBOL, '1', HeadDirection.Right, 3),
                new Transition(8, '1', '1', HeadDirection.Left, 8),
                new Transition(9, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 10),
                new Transition(9, '1', '1', HeadDirection.Left, 9),
                new Transition(10, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 12),
                new Transition(10, '1', '1', HeadDirection.Left, 11),
                new Transition(11, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 0),
                new Transition(11, '1', '1', HeadDirection.Left, 11),
                new Transition(12, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Right, 12),
                new Transition(12, '1', BLANK_SYMBOL, HeadDirection.Right, 13),
                new Transition(13, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.NoMove, State.HALT),
                new Transition(13, '1', BLANK_SYMBOL, HeadDirection.Right, 13),
                new Transition(14, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.NoMove, State.HALT),
                new Transition(14, '1', BLANK_SYMBOL, HeadDirection.Right, 14),
                new Transition(15, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.Left, 16),
                new Transition(15, '1', BLANK_SYMBOL, HeadDirection.Left, 15),
                new Transition(16, BLANK_SYMBOL, BLANK_SYMBOL, HeadDirection.NoMove, State.HALT),
                new Transition(16, '1', BLANK_SYMBOL, HeadDirection.Left, 16)

        );
    }
}