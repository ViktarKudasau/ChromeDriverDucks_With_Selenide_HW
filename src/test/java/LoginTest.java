import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String Expected_Success_Message = "You are now logged in as Viktar Kudasau.";
    String Expected_Error_Message = "Wrong password or the account is disabled, or does not exist";

    @Test
    public void TestIncorrectLogin() {
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), Expected_Error_Message,
                "Actual error message is " + "'" + mainPage.getErrorMessage() + "'");
    }

    @Test
    public void TestCorrectLogin() {
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), Expected_Success_Message,
                "Actual success message is " + "'" + mainPage.getSuccessMessage() + "'");
    }
}
