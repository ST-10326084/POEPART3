import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    private Login login;
    
    @BeforeEach
    public void setUp() { // (Coding with John, 2022)
        // Initialize the Login instance with test data
        login = new Login("username", "Password123!");
    }

    @Test
    public void testCheckUserName() { // (Coding with John, 2022)
        // Test checking the username
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() { // (Coding with John, 2022)
        // Test checking the password complexity
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() { // (Coding with John, 2022)
        // Test registering a user with valid username and password
        assertEquals("Registration successful!", login.registerUser());
    }

    @Test
    public void testLoginUser() { // (Coding with John, 2022)
        // Test logging in with valid username and password
        assertTrue(login.loginUser());
    }

    @Test
    public void testReturnLoginStatus() { // (Coding with John, 2022)
        // Test returning the login status for a successful login
        assertEquals("Login successful!", login.returnLoginStatus(true));

        // Test returning the login status for a failed login
        assertEquals("Login failed. Please check your username and password and try again.", login.returnLoginStatus(false));
    }
}

/**
 * Coding with John 2022. Java Unit Testing with JUnit - Tutorial - How to Create And Use Unit Tests. YouTube. Available at: https://www.youtube.com/watch?v=vZm0lHciFsQ&t=121s [Accessed 7 Jul. 2023].
‌**/