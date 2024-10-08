package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
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

    @Key("videoUrl")
    String getVideoUrl();
}
