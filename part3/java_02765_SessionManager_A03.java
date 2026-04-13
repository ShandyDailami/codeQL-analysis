// Start of code
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.config.annotation.web.SpringSessionConfiguration;
import org.springframework.session.data.redis.config.annotation.web.SpringSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.AbstractSessionRepositoryDefinitionParser;
import org.springframework.session.data.redis.connection.RedisConnectionFactory;
import org.springframework.session.data.redis.connection.RedisConnection;

@Configuration
@EnableRedisHttpSession
public class java_02765_SessionManager_A03 {

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("localhost");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }

    @Bean
    public SpringSessionConfiguration springSessionConfiguration() {
        return new SpringSessionConfiguration();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistry();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

public class UserSession {

    private String sessionId;

    public java_02765_SessionManager_A03(String sessionId) {
        this.sessionId = sessionId;
    }

    // getters and setters
}

public class SessionRegistry {

    private Map<String, UserSession> sessions = new ConcurrentHashMap<>();

    public void registerSession(UserSession userSession) {
        sessions.put(userSession.getSessionId(), userSession);
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void unregisterSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class SessionRegistryExample {

    private static SessionRegistry sessionRegistry;

    @Autowired
    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        SessionRegistryExample.sessionRegistry = sessionRegistry;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SessionConfig.class);

        // Start a session
        UserSession userSession = new UserSession(UUID.randomUUID().toString());
        sessionRegistry.registerSession(userSession);

        // Get the session
        UserSession retrievedSession = sessionRegistry.getSession(userSession.getSessionId());
        System.out.println(retrievedSession);

        // Stop the session
        sessionRegistry.unregisterSession(userSession.getSessionId());
    }
}
// End of code