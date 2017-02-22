package Tests;

import Methods.LoginPage;
import Methods.MyProfilePage;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;

/**
 * Created by asus on 09.02.17.
 */
public class MyProfileTest extends BaseTest {

    @Test
    public void openPersonalInfo() throws InterruptedIOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.showProfile(driver);
        loginPage.logout(driver);
    }

    @Test
    public void changePersonalInfo() throws InterruptedIOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.changeProfile(driver);
        loginPage.logout(driver);
    }

    @Test
    public void emptyPersonalInfo() throws InterruptedIOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver,"vasiliy.fedortsi@thinkmobiles.com", "111111");
        MyProfilePage myProfilePage = new MyProfilePage();
        myProfilePage.errorProfile(driver);
        loginPage.logout(driver);
    }
}
