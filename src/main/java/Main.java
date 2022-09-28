import generator.ArithmeticProblemGenerator;
import pojo.MathProblem;
import utils.FileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zz
 * @Date: 2022/09/27 22:15
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入生成题目的数字范围：");
        System.out.println("例：输入10，将生成10以内（不包括10）的四则运算题目。");
        int range = sc.nextInt();
        System.out.println("请输入生成题目的个数：");
        System.out.println("例：输入10，将生成10道题");
        int count = sc.nextInt();
        ArithmeticProblemGenerator arithmeticProblemGenerator = new ArithmeticProblemGenerator();
        List<MathProblem> mathProblemList = arithmeticProblemGenerator.getMathProblemList(count, range);
        FileUtils.writeToFile(mathProblemList);
        System.out.println("题目生成完毕，完成题目后输入ok比对答案");
        String next = sc.next();
        if (next.equals("ok")){
            FileUtils.checkAnswer();
        }
    }
}
