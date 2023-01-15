package br.com.anderson.cassandrademo.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.NoSuchAlgorithmException;

@Configuration
public class AmazonKeyspacesConfig {

    private final String username = "keyspaces_credentials";

    private final String password = "keyspaces_credentials";

    File driverConfig = new File(System.getProperty("user.dir")+"/src/main/resources/application.conf");

    @Primary
    public @Bean
    CqlSession session() throws NoSuchAlgorithmException {
        return CqlSession.builder()
                .withConfigLoader(DriverConfigLoader.fromFile(driverConfig))
                .withAuthCredentials(username, password)
                .withSslContext(SSLContext.getDefault())
                .withKeyspace("keyspace_name")
                .build();
    }
}
