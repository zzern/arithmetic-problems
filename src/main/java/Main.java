import generator.ArithmeticProblemGenerator;
import pojo.MathProblem;
import utils.FileUtils;

import java.io.IOException;
import java.util.List;

/**
 * @Author: zz
 * @Date: 2022/09/27 22:15
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArithmeticProblemGenerator apg = new ArithmeticProblemGenerator();
        List<MathProblem> mathProblemList = apg.getMathProblemList(10, 10);
        FileUtils.writeToFile(mathProblemList);
    }
}
