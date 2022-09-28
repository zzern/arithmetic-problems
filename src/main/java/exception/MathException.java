package exception;

/**
 * @Author: zz
 * @Date: 2022/09/28 14:12
 * @Description:
 */
public class MathException extends RuntimeException{
    public MathException(){}
    public MathException(String message){
        super(message);
    }
}
