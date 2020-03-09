import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest {
    PasswordChecker pc = new PasswordChecker();


    @Test
    public void passwordIsValid() throws PasswordChecker.PasswordException {
        Assert.assertTrue(pc.passwordIsValid("Manqasana@3"));

    }

    @Test
   public void passwordOK() throws PasswordChecker.PasswordException {
        String expected = "Password is valid";
        Assert.assertEquals(expected,pc.passwordIsOK("Manqasana@3"));
    }

}