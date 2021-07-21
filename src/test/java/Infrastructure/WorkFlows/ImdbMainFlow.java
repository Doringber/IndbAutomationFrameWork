package Infrastructure.WorkFlows;

import Infrastructure.Extention.Click;
import Infrastructure.Extention.UpdateText;
import Infrastructure.Extention.VerifyText;
import Infrastructure.Uitiles.CommanOps;
import jdk.internal.org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class ImdbMainFlow extends CommanOps {
    public static void searchItem(String searchItem) throws IOException, ParseException, ParserConfigurationException, SAXException
    {
        UpdateText.text(ImdbPage.search, searchItem);
        Click.go(ImdbPage.getSearchButton);
        VerifyText.textInElement(ImdbPage.findSearchTerm, '"' + searchItem + '"');
    }
}
