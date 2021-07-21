package TestCase;

import Infrastructure.Uitiles.CommanOps;
import Infrastructure.WorkFlows.ImdbMainFlow;
import jdk.internal.org.xml.sax.SAXException;
import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class ImdbMain extends CommanOps {

    @Test
    public void test01_ClickOnSearch() throws IOException, ParseException, ParserConfigurationException, SAXException {
        ImdbMainFlow.searchItem("star wars");
    }
}
