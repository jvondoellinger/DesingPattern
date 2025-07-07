package service.impl.email.config;

import configuration.enviroment.EnvironmentGetter;

public class UserEmailConfig {
    final String username;

    final String password;

    @Override
    public String toString() {
        return "UserEmailConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserEmailConfig(EnvironmentGetter environmentGetter) {
        username = environmentGetter.getString("USERNAME");
        password = environmentGetter.getString("PASSWORD");
    }
    // Getter
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
