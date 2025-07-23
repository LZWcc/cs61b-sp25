public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    /* 树的根节点。Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /**
         * 创建一个RBTreeNode，包含项目ITEM，颜色取决于ISBLACK值。
         * Creates a RBTreeNode with item ITEM and color depending on ISBLACK value.
         * @param isBlack
         * @param item
         */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /**
         * 创建一个RBTreeNode，包含项目ITEM，颜色取决于ISBLACK值，左子节点LEFT，右子节点RIGHT。
         * Creates a RBTreeNode with item ITEM, color depending on ISBLACK value, left child LEFT, and right child RIGHT.
         * @param isBlack
         * @param item
         * @param left
         * @param right
         */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Creates an empty RedBlackTree.
     * 创建一个空的红黑树。
     */
    public RedBlackTree() {
        root = null;
    }

    /**
     * 翻转节点及其子节点的颜色。假设NODE有左右两个子节点。
     * Flips the color of node and its children. Assume that NODE has both left and right children
     * @param node
     */
    void flipColors(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
    }

    /**
     * 将给定节点向右旋转。返回此子树的新根节点。在此实现中，确保交换新根和旧根的颜色！
     * Rotates the given node to the right. Returns the new root node of this subtree.
     * For this implementation, make sure to swap the colors of the new root and the old root!
     * @param node
     * @return
     */
    //    在右旋中，颜色的变化应该是：
    //    新根 x（temp）继承原根 h（node）的颜色。
    //    原根 h（node）变为红色。
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        // 保存当前节点的左子节点
        RBTreeNode<T> temp = node.left;
        // 保存左子节点的颜色
        Boolean saveColor = node.left.isBlack;

        // 当前节点的左子节点应该更新为 temp 的右子节点
        node.left = temp.right;
        // 新根为 temp, temp.right = node;
        temp.right = node;

        // 交换新根和旧根的颜色
        temp.isBlack = node.isBlack;    // 新根为旧根的颜色
        node.isBlack = saveColor;
        return temp;
    }

    /**
     * 将给定节点向左旋转。返回此子树的新根节点。在此实现中，确保交换新根和旧根的颜色！
     * Rotates the given node to the left. Returns the new root node of this subtree.
     * For this implementation, make sure to swap the colors of the new root and the old root!
     * @param node
     * @return
     */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        RBTreeNode<T> temp = node.right;
        Boolean saveColor = node.right.isBlack;
        node.right = temp.left;
        temp.left = node;
        temp.isBlack = node.isBlack;
        node.isBlack = saveColor;
        return temp;
    }

    /**
     * 辅助方法，返回给定节点是否为红色。空节点（子节点或叶节点）自动被视为黑色。
     * Helper method that returns whether the given node is red. Null nodes (children or leaf nodes)
     * are automatically considered black.
     * @param node
     * @return
     */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

    /**
     * Inserts the item into the Red Black Tree. Colors the root of the tree black.
     * 将项目插入红黑树。将树的根节点设为黑色。
     * @param item
     */
    public void insert(T item) {
        root = insertHelper(root, item);
        root.isBlack = true;
    }

    /**
     * Helper method to insert the item into this Red Black Tree. Comments have been provided to help break
     * down the problem. For each case, consider the scenario needed to perform those operations.
     * Make sure to also review the other methods in this class!
     * 插入项目到红黑树的辅助方法。已提供注释以帮助分解问题。对于每种情况，考虑执行这些操作所需的场景。
     * 确保还要查看此类中的其他方法！
     * @param node
     * @param item
     * @return
     */
    private RBTreeNode<T> insertHelper(RBTreeNode<T> node, T item) {
        // TODO: Insert (return) new red leaf node.
        // 插入（返回）新的红色叶节点。
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // TODO: Handle normal binary search tree insertion.
        // 处理正常的二叉搜索树插入。
        int cmp = item.compareTo(node.item);
        if (cmp < 0) {
            node.left = insertHelper(node.left, item);
        } else if (cmp > 0) {
            node.right = insertHelper(node.right, item);
        }

        // TODO: Rotate left operation
        // 左旋转操作
        /* 必须加上!isRed(node.left)判断!!! 否则以下情况会错误左旋*/
    //          (10)
    //          /  \
    //        (5)* (15)*
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        // TODO: Rotate right operation
        // 右旋转操作
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        // TODO: Color flip
        // 颜色翻转
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

}
