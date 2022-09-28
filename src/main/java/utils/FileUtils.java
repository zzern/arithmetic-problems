package utils;

import pojo.MathProblem;

import java.io.*;
import java.util.ArrayList;
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
    /**
    *
    * @param
    * @return
    * @description:根据文件内容比对答案并写入Grade.txt
    */
    public static void checkAnswer() throws IOException {
        BufferedReader readerExercises = null;
        BufferedReader readerAnswer = null;
        BufferedWriter resultWriter = null;
        List<String> correctNumber = new ArrayList<>();
        List<String> wrongNumber = new ArrayList<>();
        try {
            readerExercises = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/Exercises.txt")));
            readerAnswer = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"/Answer.txt")));
            resultWriter = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"/Grade.txt")));
            while (true) {
                String exercise = readerExercises.readLine();
                if (exercise == null) break;
                String answer = readerAnswer.readLine();
                String[] split = exercise.split("=");
                String[] split1 = answer.split("\\.");
                //获取题号
                String titleNum = split1[0];
                //做题写入的答案
                String myAnswer = split[1];
                //正确答案
                String correctAnswer = split1[1];
                if (myAnswer.equals(correctAnswer)){
                    correctNumber.add(titleNum);
                }else {
                    wrongNumber.add(titleNum);
                }
            }

//            Correct: 5 (1, 3, 5, 7, 9)
//
//            Wrong: 5 (2, 4, 6, 8, 10)
            //正确题号
            StringBuilder sb = new StringBuilder();
            sb.append("Correct: ");
            sb.append(correctNumber.size());
            sb.append(" (");
            for (int i = 0; i < correctNumber.size() - 1; ++i){
                sb.append(correctNumber.get(i));
                sb.append(", ");
            }
            if (correctNumber.size() != 0){
                sb.append(correctNumber.get(correctNumber.size() - 1));
            }
            sb.append(")");
            resultWriter.write(sb.toString());
            resultWriter.newLine();
            //错误题号
            sb = new StringBuilder();
            sb.append("Wrong: ");
            sb.append(wrongNumber.size());
            sb.append(" (");
            for (int i = 0; i < wrongNumber.size() - 1; ++i){
                sb.append(wrongNumber.get(i));
                sb.append(", ");
            }
            if (wrongNumber.size() != 0){
                sb.append(wrongNumber.get(wrongNumber.size() - 1));
            }
            sb.append(")");
            resultWriter.write(sb.toString());
            resultWriter.newLine();
            resultWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            readerExercises.close();
            readerExercises.close();
            resultWriter.close();
        }
    }
}
