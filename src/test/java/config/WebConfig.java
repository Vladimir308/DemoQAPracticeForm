package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})

public interface WebConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteUrl();
}
