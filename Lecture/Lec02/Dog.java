package Lec02;

public class Dog {
    public int size;
    public static String binomen = "Canis familiaris";

    /* 构造函数 */
    public Dog(int s) {
        size = s;
    }
    public void makeNoise() {
        if (size > 20) {
            System.out.println("arooooo!");
        } else if (size < 10) {
            System.out.println("bark");
        } else {
            System.out.println("yipyipyipyip");
        }
    }

    /* 两种不同的maxDog方法 */
    public static Dog maxDog(Dog a, Dog b) {
        if (a.size > b.size) {
            return a;
        }
        return b;
    }

    // 将自身与另一只狗比较
    /* 方法重载 */
    public Dog maxDog(Dog otherDog) {
        if (this.size > otherDog.size) {
            return this;
        }
        return otherDog;
    }
}
