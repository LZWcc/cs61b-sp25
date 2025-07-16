import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    // TODO: Add any necessary instance variables.
    // TODO: 添加任何必要的实例变量。
    private int N;
    private int cnt;
    private int[][] state;
    private WeightedQuickUnionUF uf;
    private int dummyTop;
    private int dummyBottom;
    private WeightedQuickUnionUF percolate;
    private WeightedQuickUnionUF backwash;
    // 创建一个 N×N 的网格，所有位置最初都是封闭的
    // index = row * N + col;
    public Percolation(int N) {
        // TODO: Fill in this constructor.
        // TODO: 填写此构造函数。
        this.N = N;
        state = new int[N][N];
        cnt = 0;
        dummyTop = N * N;
        dummyBottom = N * N + 1;
        percolate = new WeightedQuickUnionUF(N * N + 2);  // 包含顶部和底部的虚拟节点
        backwash = new WeightedQuickUnionUF(N * N + 1);   // 只包含顶部虚拟节点
    // public WeightedQuickUnionUF(int n) creates a UF with n elements

    }

    // 如果 (row, col) 位置不是打开的，就将其打开
    public void open(int row, int col) {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        if (!isOpen(row, col)) {
            state[row][col] = 1;
            cnt++;
            int idx = row * N + col;
            if (row == 0) {
                backwash.union(idx, dummyTop);
                percolate.union(idx, dummyTop);
            }
            if (row == N - 1) {
                percolate.union(idx, dummyBottom);
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++) {
                int x = row + dx[i], y = col + dy[i];
                if (x >= N || y >= N || x < 0 || y < 0) continue;
                if (isOpen(x, y)) {
                    int tmp = x * N + y;
                    backwash.union(idx, tmp);
                    percolate.union(idx, tmp);
                }
            }
        }
    }

    // 判断 (row, col) 位置是否是打开的
    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        return state[row][col] != 0;
    }

    // 判断 (row, col) 位置是否是“满的”（与顶部连通）
    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        return isOpen(row, col) && backwash.connected(row * N + col, dummyTop);
    }

    // 返回当前打开位置的数量
    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        return cnt;
    }

    // 判断系统是否渗透（顶到底是否连通）
    public boolean percolates() {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        return percolate.connected(dummyTop, dummyBottom);
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: 添加任何有用的辅助方法（我们强烈推荐这样做！）。
    // TODO: Remove all TODO comments before submitting.
    // TODO: 在提交前移除所有 TODO 注释。

}
