package me.algorithm.ch02.extend;

/**
 * Created by Administrator on 2016/12/5.
 */
public class HanoiTest {
    public static void hanoi(int n,char A,char B,char C){
        if (n == 1) {
            move(A,C);
            return;
        }
        //先把A上的n-1个圆盘移到B上
        hanoi(n - 1,A,C,B);
        //把A上最后一个圆盘移到C上
        move(A,C);
        //接下来递归,把B上的n-1个圆盘移到C上
        hanoi(n - 1,B,A,C);
    }
    /**
     * 把A最上面的圆盘移到C上面
     */
    private static void move(char A,char C){
        System.out.println(A + "--->" + C);
    }
    public static void main(String[] args){
        hanoi(3,'A','B','C');
    }
}
