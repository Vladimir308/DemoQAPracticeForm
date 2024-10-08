package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.remote;

public class WebDriverProvider {

    private WebConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
        createWebDriver();
    }

    private void createWebDriver() {
        Configuration.baseUrl = config.getBaseUrl();
        switch (config.getBrowserName().toLowerCase()) {
            case "chrome": {
                Configuration.browser = "chrome";
                break;
            }
            case "firefox": {
                Configuration.browser = "firefox";
                break;
            }
            default:
                throw new RuntimeException("No such driver: + " + config.getBrowserName());
        }

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserVersion = config.getBrowserVersion();
        String remoteUrl = config.getRemoteUrl();
        if (remoteUrl != null) {
            remote = remoteUrl;
            Configuration.pageLoadStrategy = "eager";
            Configuration.pageLoadTimeout = 100000;
            Configuration.timeout = 15000;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));

            Configuration.browserCapabilities = capabilities;
        }
    }
}