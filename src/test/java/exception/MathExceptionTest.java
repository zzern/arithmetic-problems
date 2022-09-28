package exception;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zz
 * @Date: 2022/09/28 15:46
 * @Description:
 */
public class MathExceptionTest {
    @Test
    public void test1(){
        new MathException();
        new MathException("该分数不是假分数");
        throw new MathException("该分数不是假分数");
    }
}