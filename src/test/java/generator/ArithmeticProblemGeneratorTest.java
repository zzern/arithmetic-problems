package generator;

import org.junit.Test;
import pojo.MathProblem;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zz
 * @Date: 2022/09/28 15:13
 * @Description:
 */
public class ArithmeticProblemGeneratorTest {

    ArithmeticProblemGenerator arithmeticProblemGenerator = new ArithmeticProblemGenerator();
    @Test
    public void generateOneMathProblem() {
        MathProblem mathProblem = arithmeticProblemGenerator.generateOneMathProblem(10);
        System.out.println(mathProblem);
    }

    @Test
    public void getMathProblemList() {
        List<MathProblem> mathProblemList = arithmeticProblemGenerator.getMathProblemList(10, 10);
        mathProblemList.stream().forEach(System.out::println);
    }
}