package bomb;

import common.IntList;

public class BombMain {
    public static void answers(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: 使用调试技巧找出每个阶段的正确输入（密码）
        // TODO: Find the correct inputs (passwords) to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            // TODO: 找出 phase0 的正确输入
            b.phase0("39291226");
        }
        if (phase >= 1) {
            // TODO: 找出 phase1 的正确输入
            b.phase1(IntList.of(0, 9, 3, 0, 8)); // Figure this out too
        }
        if (phase >= 2) {
            // TODO: 找出 phase2 的正确输入
            b.phase2("793227803");
        }
    }
}
