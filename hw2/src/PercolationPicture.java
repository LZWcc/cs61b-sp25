import java.awt.Font;
import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationPicture {
    // delay in miliseconds (controls animation speed)
    // 延迟时间（毫秒）（控制动画速度）
    private static final int DELAY = 100;

    // draw N-by-N percolation system
    // 绘制 N×N 渗透系统
    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-.05 * N, 1.05 * N);
        StdDraw.setYscale(-.05 * N, 1.05 * N);   // leave a border to write text
                                                  // 留出边界来写文本

        // draw N-by-N grid
        // 绘制 N×N 网格
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                boolean open = perc.isOpen(row, col);
                boolean full = perc.isFull(row, col);
                if (open && full) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                } else if (open) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                } else if (!full) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                } else {
                    StdDraw.setPenColor(StdDraw.MAGENTA); // should never happen
                                                          // 不应该发生
                }
                StdDraw.filledSquare(col + 0.5, N - row - 0.5, 0.499);
            }
        }

        // write status text
        // 写状态文本
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25 * N, -N * .025, perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) {
            StdDraw.text(.75 * N, -N * .025, "percolates");
        } else {
            StdDraw.text(.75 * N, -N * .025, "does not percolate");
        }
    }

    // this is the implementation of deprecated StdDraw.show(int t)
    // 这是已弃用的 StdDraw.show(int t) 的实现
    public static void show(int t) {
        StdDraw.show();
        StdDraw.pause(t);
        StdDraw.enableDoubleBuffering();
    }

    private static void simulateFromFile(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);

        // turn on animation mode
        // 开启动画模式
        show(0);

        // repeatedly read in sites to open and draw resulting system
        // 重复读入要打开的站点并绘制结果系统
        draw(perc, N);
        show(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            show(DELAY);
        }
    }

    // pick a random file from the inputFiles folder
    // 从 inputFiles 文件夹中随机选择一个文件
    private static String pickRandomFile() {
        File[] ar = new File("inputFiles").listFiles();
        if (ar == null) {
            throw new RuntimeException("could not find inputFiles");
        }
        return "inputFiles/" + ar[StdRandom.uniform(ar.length)].getName();
    }

    public static void main(String[] args) {
        String filename;
        if (args.length == 1) {
            filename = args[0];
        } else {
            filename = pickRandomFile();
        }
        System.out.println("Drawing file " + filename);
        simulateFromFile(filename);
    }
}
