import org.testng.annotations.Test;

/**
 * Created by asus on 09.02.17.
 */
public class MyProfile extends Base {

    @Test
    public void incorrectEmail() {
        driver.get(baseUrl + "/users/sign_in");
        login("focus@gmail.com", "focus5080");
    }

}
