package Lec16;

import java.security.Key;

public class BST {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key key, BST left, BST Right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

    // sk 即search key
    static BST find (BST T, key sk) {
        if (T == null) {
            return null;
        }
        if (sk.equals(T.key)) {
            return T;
        } else if (sk < T.key) {
            return find(T.left, sk);
        } else {
            return find(T.right, sk);
        }
    }

    static BST insert(BST T, key ik) {
        if (T == null) {    // 当发现当前节点下有可插入的位置(即null)
            return new BST(ik);
        }
        if (ik < T.key) {
            T.left = insert(T.left, ik);
        } else if (ik > T.key) {
            T.right = insert(T.right, ik);
        }
        return T;
    }
}
