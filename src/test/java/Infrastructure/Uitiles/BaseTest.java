package Infrastructure.Uitiles;

import Infrastructure.PageObject.ImdbHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTest {
        public static WebDriver driver;
        static DesiredCapabilities dc = new DesiredCapabilities();
        public static ExtentReports extent;
        public static ExtentTest test;
        public static RequestSpecification httpRequest;
        public static JSONObject requestParams = new JSONObject();
        public static Connection.Response resp;
        public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        public static String myPlatform;
        public static JavascriptExecutor js = (JavascriptExecutor) driver;
        public static ImdbHomePage ImdbPage;
        public static getConfig configuration;

        static {
                try {
                        configuration = new getConfig();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }


}
