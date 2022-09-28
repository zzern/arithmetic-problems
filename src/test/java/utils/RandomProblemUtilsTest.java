package utils;

import org.junit.Test;
import utils.RandomProblemUtils;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: zz
 * @Date: 2022/09/28 15:13
 * @Description:
 */
public class RandomProblemUtilsTest {

    @Test
    public void getRandomNum() {
        Integer randomNum = RandomProblemUtils.getRandomNum(0, 10);
        System.out.println(randomNum.toString());
    }

    @Test
    public void generateNaturalNumber() {
        String s = RandomProblemUtils.generateNaturalNumber(10);
        System.out.println(s);
    }

    @Test
    public void generateFraction() {
        String s = RandomProblemUtils.generateFraction(10);
        System.out.println(s);
    }

    @Test
    public void daiFractionToFalseFraction() {
        String s = RandomProblemUtils.DaiFractionToFalseFraction("2'1/2");
        System.out.println(s);
    }

    @Test
    public void falseFractionToDaiFraction() {
        String s = RandomProblemUtils.FalseFractionToDaiFraction("12/7");
        System.out.println(s);
    }
    @Test
    public void falseFractionToDaiFraction1() {
        String s = RandomProblemUtils.FalseFractionToDaiFraction("12");
        System.out.println(s);
    }
    @Test
    public void checkFraction() {
        int i = RandomProblemUtils.checkFraction("1/2");
        int i1 = RandomProblemUtils.checkFraction("2'1/2");
        System.out.println(i);
        System.out.println(i1);
    }

    @Test
    public void about() {
        String about = RandomProblemUtils.About("12/3");
        System.out.println(about);
    }

    @Test
    public void getMaxCommonFactor() {
        int maxCommonFactor = RandomProblemUtils.getMaxCommonFactor(6, 12);
        System.out.println(maxCommonFactor);
    }

    @Test
    public void getDenominato() {
        int denominato = RandomProblemUtils.getDenominato("6/12");
        System.out.println(denominato);
    }

    @Test
    public void getMolecule() {
        int molecule = RandomProblemUtils.getMolecule("6/12");
        System.out.println(molecule);
    }

    @Test
    public void reductionFraction() {
        String[] strings = RandomProblemUtils.reductionFraction("12/6", "2/4");
        Arrays.stream(strings).forEach(System.out::println);
    }

    @Test
    public void binocularOperation() {
        String s = RandomProblemUtils.BinocularOperation("1/2", "1'1/2", "+");
        System.out.println(s);
    }
}