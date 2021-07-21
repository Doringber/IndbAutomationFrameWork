package Infrastructure.Extention;

import Infrastructure.Uitiles.CommanOps;
import jdk.internal.org.xml.sax.SAXException;
import org.openqa.selenium.WebElement;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class UpdateText extends CommanOps {
    public static void text(WebElement elem, String value)
    throws IOException, ParseException, ParserConfigurationException, SAXException {
        try {
            elem.sendKeys(value);
//            test.log(LogStatus.PASS, "Text filed Updated successfully, This is the value: " + value);
        } catch (Exception e) {
//            test.log(LogStatus.FAIL, "Failed to Updated Text Element, details: " + e + "See screenshot"
//                    + test.addScreenCapture(takeSS()));
//            fail("Failed to Updated Text Element ");
}
}

}