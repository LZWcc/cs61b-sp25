package Lec15;

public class DisjointSets {
    public int[] parent;
    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];    // 向上找直到找到根
        }

        // 路径压缩
        while (p != root) {
            int newp = parent[p];   // 暂存原来的父节点
            parent[p] = root;       // 将当前节点直接指向根节点
            p = newp;               // 继续向上处理
        }
        return root;
    }
}
