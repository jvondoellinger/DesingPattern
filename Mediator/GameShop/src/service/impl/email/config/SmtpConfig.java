package service.impl.email.config;

import configuration.enviroment.EnvironmentGetter;

public class SmtpConfig {
    final EnvironmentGetter environmentGetter;

    public SmtpConfig(EnvironmentGetter environmentGetter) {
        this.environmentGetter = environmentGetter;
        host = environmentGetter.getString("SMTP_HOST");
        port = environmentGetter.getInteger("SMTP_PORT");
        System.out.println(toString());
    }
    final String host;
    final Integer port;

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "SmtpConfig{" +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
