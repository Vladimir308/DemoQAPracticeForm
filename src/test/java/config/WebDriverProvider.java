package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {

    private WebConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
        createWebDriver();
    }

    private void createWebDriver() {
        switch (config.getBrowserName().toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            default:
                throw new RuntimeException(config.getBrowserName());
        }


        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemoteUrl();
        Configuration.browserSize = config.getBrowserSize();
    }
}