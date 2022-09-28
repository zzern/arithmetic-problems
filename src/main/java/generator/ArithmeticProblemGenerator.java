package generator;

import constant.OperatorConstant;
import pojo.MathProblem;
import utils.RandomProblemUtils;

import java.util.*;

/**
 * @Author: zz
 * @Date: 2022/09/28 14:21
 * @Description:算术题生成器
 */
public class ArithmeticProblemGenerator {
    /**
     * 生成范围内的一条题目
     * @param range  运算数范围
     * @return
     */
    public MathProblem generateOneMathProblem(int range) {
        MathProblem mathProblem = new MathProblem();
        //获得随机运算法数量
        int operatorNum = RandomProblemUtils.getRandomNum(1,3);
        List<String> operatorList = new ArrayList<String>();
        String operator = null;
        //给运算符赋值
        for (int i = 0; i < operatorNum ; i++) {
            operator = OperatorConstant.operatorMap.get((Integer) RandomProblemUtils.getRandomNum(1, 4));
            operatorList.add(operator);
        }
        //给运算值赋值
        List<String> numList = new ArrayList<String>();
        int flag = 0;
        for (int i = 0; i < operatorList.size()+1 ; i++) {
            flag = RandomProblemUtils.getRandomNum(0,1);
            if(flag == 0){
                //生成分数
                numList.add(RandomProblemUtils.generateFraction(range));
            }else {
                //生成自然数
                numList.add(RandomProblemUtils.generateNaturalNumber(range));
            }
        }
        mathProblem.setData(numList);
        mathProblem.setOperator(operatorList);
        mathProblem.setProblemString(generateExerciseStr(mathProblem));
        mathProblem.setAnswer(getAnswer(mathProblem));
        return mathProblem;
    }

    /**
     * 根据MathProblem对象获取符合题目格式的输出
     * @param mathProblem 题目
     * @return
     */
    private static String generateExerciseStr(MathProblem mathProblem) {
        Queue<String> queue = new LinkedList<>();
        List<String> operators = mathProblem.getOperator();
        List<String> numbers = mathProblem.getData();
        for (int i = 0; i < numbers.size() ; i++) {
            queue.add(numbers.get(i));
        }
        String exerciseStr = "";
        for (int i = 0; i < operators.size() ; i++) {
            String operator = operators.get(i);
            String num1 = queue.remove();
            String num2 = queue.remove();
            if(i != operators.size()-1){
                exerciseStr = OperatorConstant.LEFT_BRACKETS+num1+operator+num2+OperatorConstant.RIGHT_BRACKETS;
            }else {
                exerciseStr = num1+operator+num2;
            }
            queue.add(exerciseStr);
        }
        StringBuilder sb = new StringBuilder("").append(queue.remove()).append("=");
        return sb.toString();
    }
    /**
     * 获取题目答案
     * @param mathProblem  题目
     * @return
     */
    private static String getAnswer(MathProblem mathProblem) {
        List<String> numbers = mathProblem.getData();
        List<String> operators = mathProblem.getOperator();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            String s = numbers.get(i);
            if(RandomProblemUtils.checkFraction(s) == 3){
                s = RandomProblemUtils.DaiFractionToFalseFraction(s);
            }
            queue.add(s);
        }
        for (int i = 0; i < operators.size() ; i++) {
            String operator = operators.get(i);
            String num1 = queue.remove();
            String num2 = queue.remove();
            String answer = RandomProblemUtils.BinocularOperation(num1,num2,operator);
            if(answer == null){
                mathProblem.setAnswer(null);
                return "";
            }
            if(RandomProblemUtils.checkFraction(answer) == 2){
                answer = RandomProblemUtils.FalseFractionToDaiFraction(answer);
            }
            queue.add(answer);
        }
        return queue.remove();
    }

    /**
     * 根据题目数量和范围获取练习题
     * @param mathProblemsNum  生成题目数量
     * @param range     题目运算数的范围
     * @return         所有题目
     */
    public List<MathProblem> getMathProblemList(int mathProblemsNum, int range) {
        List<MathProblem> mathProblemList = new ArrayList<>();
        for (int i = 1; i <= mathProblemsNum; ++i){
            MathProblem mathProblem = generateOneMathProblem(range);
            mathProblem.setTitleNumber(i);
            mathProblemList.add(mathProblem);
        }
        return mathProblemList;
    }
}
