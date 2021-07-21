package Infrastructure.Uitiles;

import Infrastructure.PageObject.ImdbHomePage;
import org.openqa.selenium.support.PageFactory;

public class InitPages extends CommanOps {
    public static void init() {

        ImdbPage = PageFactory.initElements(driver, ImdbHomePage.class);

    }
}
