package configuration.enviroment;

public interface EnvironmentGetter {
    String getString(String key);
    Integer getInteger(String key);
}
