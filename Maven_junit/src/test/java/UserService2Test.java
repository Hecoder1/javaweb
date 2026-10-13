import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserService2Test {

    private final EmpService empService = new EmpService();
    // 用一个固定的测试身份证：北京 1990-03-04 女
    private static final String ID_CARD = "11010519900304202X";

    @Test
    public void testisBeijing(){
        boolean result = empService.isBeijing(ID_CARD);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testGetAge(){
        Integer result = empService.getAge(ID_CARD);
        // 1990-03-04 到 2026-10-13 → 36 岁
        Assertions.assertEquals(36, result);
    }

    @Test
    public void testGetGender(){
        String result = empService.getGender(ID_CARD);
        // 第17位是 '2' → 偶数 → 女
        Assertions.assertEquals("女", result);
    }

    @Test
    public void testGetYear(){
        String result = empService.getYear(ID_CARD);
        Assertions.assertEquals("1990", result);
    }

    @Test
    public void testGetMonth(){
        String result = empService.getMonth(ID_CARD);
        Assertions.assertEquals("03", result);
    }
}