package utils;

import generator.ArithmeticProblemGenerator;
import org.junit.Test;
import pojo.MathProblem;
import utils.FileUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zz
 * @Date: 2022/09/28 13:47
 * @Description:
 */
public class FileUtilsTest {

    @Test
    public void writeToFile() throws IOException {
        ArithmeticProblemGenerator arithmeticProblemGenerator = new ArithmeticProblemGenerator();
        List<MathProblem> mathProblemList = arithmeticProblemGenerator.getMathProblemList(10, 10);
        FileUtils.writeToFile(mathProblemList);
    }
    @Test
    public  void checkAnswer() throws IOException {
        FileUtils.checkAnswer();
    }
}