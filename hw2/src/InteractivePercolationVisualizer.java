import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class InteractivePercolationVisualizer {
    private static final int DELAY = 20;

    public static void main(String[] args) {
        // N-by-N percolation system (read from command-line, default = 10)
        // N×N 渗透系统（从命令行读取，默认值 = 10）
        int N = 5;
        if (args.length == 1) {
            N = Integer.parseInt(args[0]);
        }

        // turn on animation mode
        // 开启动画模式
        PercolationPicture.show(0);

        // repeatedly open site specified my mouse click and draw resulting system
        // 重复打开鼠标点击指定的站点并绘制结果系统
        StdOut.println(N);

        Percolation perc = new Percolation(N);
        PercolationPicture.draw(perc, N);
        PercolationPicture.show(DELAY);
        int lastClickedI = -1;
        int lastClickedJ = -1;
        while (true) {

            // detected mouse click
            // 检测鼠标点击
            if (StdDraw.isMousePressed()) {

                // screen coordinates
                // 屏幕坐标
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();

                // convert to row i, column j
                // 转换为第 i 行，第 j 列
                int i = (int) (N - Math.floor(y) - 1);
                int j = (int) (Math.floor(x));

                // open site (i, j) provided it's in bounds
                // 打开站点 (i, j)，前提是它在边界内
                if (i >= 0 && i < N && j >= 0 && j < N) {
                    if (i != lastClickedI || j != lastClickedJ) {
                        StdOut.println(i + " " + j);
                        perc.open(i, j);
                        lastClickedI = i;
                        lastClickedJ = j;
                    }
                }

                // draw N-by-N percolation system
                // 绘制 N×N 渗透系统
                PercolationPicture.draw(perc, N);
            } else {
                // if mouse is let go, allow re-clicking of same tile
                // 如果鼠标松开，允许重新点击相同的方块
                lastClickedI = -1;
                lastClickedJ = -1;
            }
            PercolationPicture.show(DELAY);
        }
    }
}
