import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserService1Test {

    private final EmpService empService = new EmpService();

    private static final String ID_CARD1="610110201909091231";  // 非北京 + 男(第17位=3奇数)
    private static final String ID_CARD2="110110201909091242";  // 北京   + 女(第17位=4偶数)

    @Test
    public void testisBeijing(){
        Assertions.assertFalse(empService.isBeijing(ID_CARD1));
        Assertions.assertTrue(empService.isBeijing(ID_CARD2));
    }

    @Test
    public void testGetAge(){
        Integer result=empService.getAge(ID_CARD1);
        Assertions.assertNotEquals(result,null);
        Assertions.assertTrue(result>0);
        Assertions.assertEquals(result,7);
    }

    @Test
    public void testGetGender(){
        Assertions.assertEquals("男", empService.getGender(ID_CARD1));
        Assertions.assertEquals("女", empService.getGender(ID_CARD2));
    }

    @Test
    public void testGetYear(){
        String result=empService.getYear(ID_CARD1);
        Assertions.assertNotEquals(result,null);
        Assertions.assertEquals(result,"2019");
    }

    @Test
    public void testGetMonth(){
        String result=empService.getMonth(ID_CARD1);
        Assertions.assertNotEquals(result,null);
        Assertions.assertEquals(result,"09");
    }
}