import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testRegisterAndLogin() { //(Coding with John, 2022)
        String[] nameAndSurname = {"John", "Doe"};
        String[] expectedOutput = {"John", "Doe"};
        String[] actualOutput = Main.registerAndLogin();
        assertArrayEquals(expectedOutput, actualOutput);
    }
}

