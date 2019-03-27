package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class check_bracketsTest {

    @Test
    public void test1() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("[]"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("{}[]"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("[()]"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("(())"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("{[]}()"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("3", check_brackets.checkBrackets("{[}"));
    }

    @Test
    public void test7() {
        Assert.assertEquals("1", check_brackets.checkBrackets("{"));
    }

    @Test
    public void test8() {
        Assert.assertEquals(check_brackets.SUCCESS, check_brackets.checkBrackets("foo(bar);"));
    }

    @Test
    public void test9() {
        Assert.assertEquals("10", check_brackets.checkBrackets("foo(bar[i);"));
    }

}