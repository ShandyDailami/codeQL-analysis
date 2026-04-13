import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class java_41391_SessionManager_A03 {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer(new ClassPathResource("application.properties"));
    }

    @Bean
    @Scope(value = org.springframework.context.annotation.ScopeConfigurer.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionManager sessionManager() {
        return new SessionManager();
    }

    public static class SessionManager {
        // SessionManager logic goes here
    }
}