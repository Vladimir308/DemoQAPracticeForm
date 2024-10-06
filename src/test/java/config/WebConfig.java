package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
        "file:~/${env}.properties",
        "file:./${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("Chrome")
    Browser browser();
    @Key("browserVersion")
    @DefaultValue("126")
    String browserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();
    @Key("isRemote")
    boolean isRemote();
    @Key("remoteUrl")
    String remoteUrl();
}
