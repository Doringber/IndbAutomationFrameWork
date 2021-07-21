package Infrastructure.PageObject;

import Infrastructure.Uitiles.CommanOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImdbHomePage extends CommanOps {

    @FindBy(id = "suggestion-search")
    public WebElement search;
    @FindBy(id = "suggestion-search-button")
    public WebElement getSearchButton;
    @FindBy(xpath = "//span[@class=\"findSearchTerm\"]")
    public WebElement findSearchTerm;
}
