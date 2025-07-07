package configuration.enviroment;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfiguration implements EnvironmentGetter {
    protected static EnvConfiguration configuration;
    final Dotenv dotenv;

    private EnvConfiguration() {
        dotenv = Dotenv.load();
    }

    public static EnvConfiguration getConfiguration() {
        if(configuration == null) {
            synchronized (EnvConfiguration.class) {
                configuration = new EnvConfiguration();
            }
        }
        return configuration;
    }

    @Override
    public String getString(String key) {
        return dotenv.get(key);
    }
    @Override
    public Integer getInteger(String key) {
        return Integer.parseInt(dotenv.get(key));
    }
}
