package Infrastructure.Extention;

import Infrastructure.Uitiles.CommanOps;

import org.openqa.selenium.WebElement;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

import static org.testng.Assert.*;

public class VerifyText extends CommanOps {
    public static void textInElement(WebElement elem, String excptedValue)
            throws IOException, ParseException, ParserConfigurationException {
        try {
            assertEquals(elem.getText(), excptedValue);
//            test.pass("Verify Text successfully");

        } catch (Exception e) {
            test.fail(
                    "Failed on the Text details: " + e + "See screenshot");
            fail("Failed on the Text");
        } catch (AssertionError e) {
            test.fail(
                    "Failed on the Text details: " + e + "See screenshot");
            fail("Failed to Verify Text");

        }
    }

    public static void contains(String response, String text) {
        try {
            assertTrue(response.contains(text));
//            test.log(LogStatus.PASS, "Contains Passed successfully");

        } catch (AssertionError e) {
//            test.log(LogStatus.FAIL,text + "Failed To be contains , details: " + e );
            fail(text + "Failed To be contains , details: " + e);
        }
    }

    public static void contains(String text) {
//        try {
//            assertTrue(Connection.Response(text));
////            test.log(LogStatus.PASS, "Contains Passed successfully");
//
//        } catch (AssertionError e) {
////            test.log(LogStatus.FAIL,text + "Failed To be contains , details: " + e );
//            fail(text + "Failed To be contains , details: " + e);		}
//    }
    }
}
