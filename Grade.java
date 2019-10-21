import java.util.Scanner;

    /****
     * 成绩等级划分 >= 90 A >=80 B >=60 C < 60 D
     *
     * @author Administrator
     *
     *         分数范围： 0 - 100 需要两个判断
     */

    public class Grade {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入分数：");
            double score = scanner.nextDouble();
            scanner.close();

            if (score < 0 || score > 100) {
                System.out.println("输入的分数不在0-100之间，不符合要求");
            } else if (score >= 90) {
                System.out.println("A");

            } else if (score >= 80) {
                System.out.println("B");

            } else if (score >= 60) {
                System.out.println("C");
            } else {
                System.out.println("D");

            }
        }

    }
