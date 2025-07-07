package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    /**
     * 将给定的方块尽可能向上移动，但不能超过minR的限制。
     *
     * @param board 当前棋盘的状态
     * @param r     要向上移动的方块的行号
     * @param c     要向上移动的方块的列号
     * @param minR  方块可以到达的最小行号，例如：
     *              如果minR为2，移动的方块不能高于第2行。
     * @return      如果发生合并，返回合并发生的行号+1；
     *              如果没有合并，则返回0。
     */
    // (row, col)
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        // TODO: Fill this in in tasks 2, 3, 4
        // TODO: 在任务2、3、4中完成此方法
        // Task2
        /* 只要上方不是空的, 就退出循环 */
        while (r > 0 && board[r - 1][c] == 0 && r > minR) {
            board[r - 1][c] = board[r][c];
            board[r][c] = 0;
            r--;    // 最上方一行r = 0, 所以使用r--
        }
        // Task3
        /* 此时上方不为空, 再判断上方的方块是否与当前方块相同 */
        if (r != 0 && board[r][c] == board[r - 1][c] && r > minR) {
            board[r - 1][c] *= 2;
            board[r][c] = 0;
            // 当前行号为 r - 1, 返回 r - 1 + 1, 即r
            return r;
        }
        // Task4 加入了 r > minR 的判断, 例如: r = 3, minR = 2, 移动才合法
        // minR == r 时, 就不能再进入循环了, 因为进入循环必移动

        return 0;
    }

    /**
     * Modifies the board to simulate the process of tilting column c
     * upwards.
     *
     * @param board     the current state of the board
     * @param c         the column to tilt up.
     */
    /**
     * 修改棋盘，以模拟将列c向上倾斜的过程。
     *
     * @param board     当前棋盘的状态
     * @param c         要向上倾斜的列
     */
    // board[row][col]
    public static void tiltColumn(int[][] board, int c) {
        // TODO: fill this in in task 5
        // TODO: 在任务5中完成此方法
        // 新的合并不能发生在 minRow 或其上方的行。
        int minRow = 0; // 初始化为0
        // 从上到下遍历每一行
        for (int i = 0; i < board.length; i++) {
            int merge = moveTileUpAsFarAsPossible(board, i, c, minRow);
            if (merge != 0) {
                /* 辅助函数的返回值为行号 + 1, 作为新的最小行号 */
                /* 如果合并发生在第0行, 必然是 r = 1的方块向上移动 return r 也为可以到达的最小行号, 即1 */
                minRow = merge;
            }
        }
        return;
    }

    /**
     * Modifies the board to simulate tilting all columns upwards.
     *
     * @param board     the current state of the board.
     */
    /**
     * 修改棋盘，以模拟将所有列向上倾斜的过程。
     *
     * @param board     当前棋盘的状态
     */
    public static void tiltUp(int[][] board) {
        // TODO: fill this in in task 6
        // TODO: 在任务6中完成此方法
        for (int i = 0; i < board.length; i++) {
            tiltColumn(board, i);
        }
        return;
    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    /**
     * 修改棋盘，以模拟将整个棋盘向给定方向倾斜。
     *
     * @param board 当前棋盘的状态
     * @param side  倾斜的方向
     */
    public static void tilt(int[][] board, Side side) {
        // TODO: fill this in in task 7
        // TODO: 在任务7中完成此方法
        // rotateRight(board);
        // rotateLeft(board);
        if (side == Side.EAST) {
            rotateLeft(board);
            tiltUp(board);
            rotateRight(board);
            return;
        } else if (side == Side.WEST) {
            rotateRight(board);
            tiltUp(board);
            rotateLeft(board);
            return;

        } else if (side == Side.SOUTH) {
            rotateLeft(board);
            rotateLeft(board);
            tiltUp(board);
            rotateRight(board);
            rotateRight(board);
            return;
        } else {
            tiltUp(board);
            return;
        }
    }
}
