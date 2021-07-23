package Infrastructure.Uitiles;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.xml.sax.SAXException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommanOps extends BaseTest{
	private static String url;
	private static String frameWork;
	private static String BrowesrType;

	public static String getData(String nodeName) throws ParserConfigurationException, IOException, org.xml.sax.SAXException {
		File fXmlFile = new File("src/test/java/Config/Data,xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();

	}

	// WebDriver - initDriver
	public static void initBrowesr(String browesrType) throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException {
		switch (browesrType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFireFox();
			break;
		case "ie":
			driver = initIEdriver();
			break;
		case "safari":
			driver = initSafariDriver();
		case "grid":
			driver = initGridDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// screen = new Screen();
	}

	private static WebDriver initGridDriver() throws MalformedURLException {
		String Node = "http://localhost:4444";
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL(Node), caps);
		return driver;
	}

	private static WebDriver initSafariDriver() {
		driver = new SafariDriver();
		return driver;
	}

	private static WebDriver initIEdriver() throws ParserConfigurationException, SAXException, IOException {
//		System.setProperty("webdriver.ie.driver", getData("IEDriverServerpath"));
		driver = new InternetExplorerDriver();
		return driver;
	}

	private static WebDriver initFireFox() throws ParserConfigurationException, SAXException, IOException {
//		System.setProperty("webdriver.gecko.driver", getData("FirefoxdriverPath"));
		driver = new FirefoxDriver();
		return driver;
	}

	private static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException {
		//setup the chromedriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		//Create Chrome Options
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-bloacking");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, option);

		//Create driver object for Chrome
		driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return driver;
	}
	// TestNG
	@BeforeSuite
	public void starSuite() throws SAXException, IOException, ParserConfigurationException, org.xml.sax.SAXException {
		instanceReport();

	}

	@AfterSuite
	public void afterSutie() {
		finalizeExtentTest();

	}

	@BeforeTest()
	public void startSession() throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException {
		initBrowesr(getData("BrowserType"));
		InitPages.init();

	}

	@AfterTest()
	public void closeSession() throws ParserConfigurationException, SAXException,
			IOException
	{
			driver.quit();

	}

	@BeforeMethod()
	public static void doBeforeTest(Method method) {
		initReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);
	}

//	@AfterMethod(groups = { "Sanity" })
//	public static void doAfterTest() throws ParserConfigurationException, SAXException, IOException {
////		if(myPlatform.equalsIgnoreCase("Web"))
////			driver.get(getData("URL"));
////		finalizeReportTest();
//
//	}

	// ExtentReports
	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException {
		extent = new ExtentReports();
//		extent.config().(getData("ReportFilePath") + "Eexcution_" + timeStamp + "/" + getData("ReportFileName") + ".html");
		extent.getStats();

	}

	public static void initReportTest(String TestName, String TestDescription) {
		test = extent.createTest(TestName, TestDescription);
	}

//	public static void finalizeReportTest() {
//		extent.close(test);
//	}

	public static void finalizeExtentTest() {
		extent.flush();
	}
}