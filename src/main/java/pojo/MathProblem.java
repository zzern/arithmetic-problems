package pojo;


import java.util.List;

/**
 * @Author: zz
 * @Date: 2022/09/27 23:15
 * @Description:题目类
 */
public class MathProblem {
    //题号
    private int titleNumber;
    //运算数
    private List<String> data;
    //运算符号
    private List<String> operator;
    //运算结果
    private String answer;
    //题目字符串
    private String problemString;

    public MathProblem() {
    }

    public int getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(int titleNumber) {
        this.titleNumber = titleNumber;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getOperator() {
        return operator;
    }

    public void setOperator(List<String> operator) {
        this.operator = operator;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getProblemString() {
        return problemString;
    }

    public void setProblemString(String problemString) {
        this.problemString = problemString;
    }
}
