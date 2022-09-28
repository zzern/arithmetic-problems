package utils;

import pojo.MathProblem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Author: zz
 * @Date: 2022/09/27 22:15
 * @Description:文件工具类
 */
public class FileUtils {
    /**
    *
    * @Date: 2022/9/27 22:17
    * @Description: 将题目与答案以文本形式写入文件
    *
    */
    public static void writeToFile(List<MathProblem> problemList) throws IOException {
        BufferedWriter problemWriter = null;
        BufferedWriter answerWriter = null;
        try {
            problemWriter = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"/Exercises.txt")));
            answerWriter = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"/Answer.txt")));
            MathProblem problem = null;
            for (int i = 0; i < problemList.size() ; i++) {
                problem = problemList.get(i);
                Integer titleNumber = problem.getTitleNumber();
                String exerciseString = problem.getProblemString();
                problemWriter.write(titleNumber.toString()+"."+exerciseString);
                answerWriter.write(titleNumber.toString()+"."+problem.getAnswer());
                problemWriter.newLine();
                answerWriter.newLine();
                problemWriter.flush();
                answerWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            problemWriter.close();
            answerWriter.close();
        }
    }
}
