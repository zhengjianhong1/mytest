import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 给定一个String类型的数组: String[] arr = {"-15", "99", "50", "10","38","-7","3"};
 * 要求:
 * <p>
 * 一.
 * 1,遍历数组,将数组中的元素转换为Integer类型,存入集合中返ArrayList集合中要求使用(Function对象,).;
 * <p>
 * 2,分别使用Stream里面的limit和skip方法,分别去掉最大值和最小值,返回流,再将流转换为集合,求去掉最大值和最小值后的剩余元素的平均值(要求使用Function);
 */
public class Test {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        String[] arr = {"-15", "99", "50", "10", "38", "-7", "3"};
        ArrayList<Integer> list = new ArrayList<>();
        for (String str : arr) {
            Function<String, Integer> f = new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return Integer.parseInt(s);
                }
            };
            int num = f.apply(str);
            list.add(num);
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    /**
     * 二.遍历要求的集合，仅利用创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
     * 1. 打印自然数的个数;
     * 2. 打印负整数的个数;
     * 3. 打印绝对值大于100的偶数的个数;
     * 4. 打印是负整数或偶数的数的个数;
     */
    public static void test02() {
        List<Integer> s = new ArrayList<>();
        s.add(-500);
        s.add(4);
        s.add(-11);
        s.add(-133);
        s.add(311);
        //a) 使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)、
        int ziran = 0;
        int fushu = 0;
        int l = 0;
        int ss = 0;
        for (Integer integer : s) {
            Predicate<Integer> p1 = i -> i >= 0;//自然数
            Predicate<Integer> p2 = i -> Math.abs(i) >= 100;//绝对值>100
            Predicate<Integer> p3 = i -> i % 2 == 0;//偶数
            if (p1.test(integer)) {
                ziran++;
            } else {
                fushu++;
            }

            if (p2.and(p3).test(integer)) {
                l++;
            }

            if (!p1.test(integer) || p3.test(integer)) {
                ss++;
            }
        }
        System.out.println("自然数的个数为" + ziran + "个");
        System.out.println("负数的个数为" + fushu + "个");
        System.out.println("绝对值大于100的偶数的个数" + l + "个");
        System.out.println("负整数或偶数的数的个数" + ss + "个");
        System.out.println("------------------------------------------");
        System.out.println("---------------------你好啊---------------------");
		System.out.println("---------------------dev---------------------");
    }
}
