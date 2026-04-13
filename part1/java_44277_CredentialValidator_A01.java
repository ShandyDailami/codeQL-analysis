import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.stereotype.*;
import java.util.Arrays; 
@Configuration @EnableWebSecurity   // Enables Spring Security and configures it to auto-configure the associated filters, etc. in an annotation configuration on classes or methods as follows: