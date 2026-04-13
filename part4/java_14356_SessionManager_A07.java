import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession(server="localhost")
@EnableSpringHttpSession(maxInactiveInterval=3600)
public class java_14356_SessionManager_A07 {

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    @Bean
    public HttpSessionManager httpSessionManager(HttpSessionStrategy httpSessionStrategy) {
        return new SessionRegistryHttpSessionManager(httpSessionStrategy);
    }
}