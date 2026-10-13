import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class UserService3Test {

    private final EmpService empService = new EmpService();

    @ParameterizedTest
    @CsvFileSource(resources = "/emp-data.csv", numLinesToSkip = 1)
    public void testAllMethods(String idcard, boolean expectedIsBeijing,
                               int expectedAge, String expectedGender,
                               String expectedYear, String expectedMonth) {

        Assertions.assertEquals(expectedIsBeijing, empService.isBeijing(idcard));
        Assertions.assertEquals(expectedAge, empService.getAge(idcard));
        Assertions.assertEquals(expectedGender, empService.getGender(idcard));
        Assertions.assertEquals(expectedYear, empService.getYear(idcard));
        Assertions.assertEquals(expectedMonth, empService.getMonth(idcard));
    }
}