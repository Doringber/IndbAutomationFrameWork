package TestCase;

import Infrastructure.Uitiles.CommanOps;
import Infrastructure.WorkFlows.ImdbMainFlow;
import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class ImdbMain extends CommanOps {

    @Test
    public void test01_ClickOnSearch() throws IOException, ParseException, ParserConfigurationException {
        ImdbMainFlow.searchItem("star wars");
    }
}
