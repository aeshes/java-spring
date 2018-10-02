package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("app")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    private final String URL = "url";
    private final String DRIVER = "driver";
    private final String USER = "user";
    private final String PASS = "pass";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASS));

        return driverManagerDataSource;
    }
}
