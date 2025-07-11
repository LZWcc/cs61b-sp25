package gh2;

import deque.Deque61B;

// TODO: maybe more imports
// TODO: 可能需要更多导入

//Note: This file will not compile until you complete the Deque61B implementations
//注意：此文件在你完成Deque61B实现之前不会编译
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * 常量。不要改变。如果你好奇，关键字final
     * means the values cannot be changed at runtime. We'll discuss this and
     * 意味着值在运行时不能被改变。我们将讨论这个和
     * other topics in lecture on Friday.
     * 其他话题在星期五的讲座中。 */
    private static final int SR = 44100;      // Sampling Rate
                                              // 采样率
    private static final double DECAY = .996; // energy decay factor
                                              // 能量衰减因子

    /* Buffer for storing sound data. */
    /* 用于存储声音数据的缓冲区。 */
    // TODO: uncomment the following line once you're ready to start this portion
    // TODO: 准备好开始这部分时取消注释下一行
    // private Deque61B<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    /* 创建给定频率的吉他弦。 */
    public GuitarString(double frequency) {
        // TODO: Initialize the buffer with capacity = SR / frequency. You'll need to
        // TODO: 用容量 = SR / frequency 初始化缓冲区。你需要
        //       cast the result of this division operation into an int. For
        //       将这个除法操作的结果转换为int。为了
        //       better accuracy, use the Math.round() function before casting.
        //       更好的精度，在转换之前使用Math.round()函数。
        //       Your should initially fill your buffer with zeros.
        //       你应该最初用零填充你的缓冲区。
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    /* 通过用白噪声替换缓冲区来拨动吉他弦。 */
    public void pluck() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        // TODO: 将缓冲区中的所有内容出队，并用随机数替换
        //       between -0.5 and 0.5. You can get such a number by using:
        //       介于-0.5和0.5之间。你可以通过使用以下方式获得这样的数字：
        //       double r = Math.random() - 0.5;
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       确保你的随机数彼此不同
        //       other. This does not mean that you need to check that the numbers
        //       这并不意味着你需要检查数字
        //       are different from each other. It means you should repeatedly call
        //       彼此不同。这意味着你应该重复调用
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        //       Math.random() - 0.5 为每个数组索引生成新的随机数。
    }

    /* Advance the simulation one time step by performing one iteration of
     * 通过执行一次迭代来使模拟前进一个时间步长
     * the Karplus-Strong algorithm.
     * Karplus-Strong算法。
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        // TODO: 将前端样本出队，并将一个新样本入队，该样本是
        //       the average of the two multiplied by the DECAY factor.
        //       两者的平均值乘以DECAY因子。
        //       **Do not call StdAudio.play().**
        //       **不要调用StdAudio.play()。**
    }

    /* Return the double at the front of the buffer. */
    /* 返回缓冲区前端的double值。 */
    public double sample() {
        // TODO: Return the correct thing.
        // TODO: 返回正确的值。
        return 0;
    }
}
    // TODO: Remove all comments that say TODO when you're done.
    // TODO: 完成后删除所有说TODO的注释。
