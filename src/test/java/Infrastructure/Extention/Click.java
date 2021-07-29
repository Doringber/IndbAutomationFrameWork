package Infrastructure.Extention;

import Infrastructure.Uitiles.CommanOps;
import org.openqa.selenium.WebElement;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class Click extends CommanOps {
        public static void go(WebElement elem)
        throws IOException, ParseException, ParserConfigurationException {
            try {
                elem.click();
                test.pass("Element clicked successfully");
            } catch (Exception e) {
//                test.log(LogStatus.FAIL,
//                        "Failed to click on Element, deatils: " + e + "See screenshot" + test.addScreenCapture(takeSS()));

//                fail("Failed to click on Element ");

    }

}
    }