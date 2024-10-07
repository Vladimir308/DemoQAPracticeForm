package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final WebConfig webDriverConfig =
            ConfigFactory.create(
                    WebConfig.class,
                    System.getProperties()
            );

    public WebConfig read() {
        return webDriverConfig;
    }
}