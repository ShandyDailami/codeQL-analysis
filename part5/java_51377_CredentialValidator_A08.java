import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("credentialValidator") // Define the bean name in Spring's application context file or directly here if you are using @Autowired annotation to inject it into your class java_51377_CredentialValidator_A08 constructor 
public class CustomCredentialsValidator {   
     private final PasswordEncoder passwordEncoder;   // Dependency Injection for BcryptPasswordEncoder (standard library) in Spring Security's context.xml or applicationContext file if you are using annotations only like @Autowired and not via xml configuration files 
     
       public CustomCredentialsValidator(final PasswordEncoder passwordEncoder){   // Constructor Injection for BcryptPasswordEncoder (standard library) in Spring Security's context.xml or applicationContext file if you are using annotations only like @Autowired and not via xml configuration files 
         this.passwordEncoder = passwordEncoder;   
       }     
       
     public boolean validate(String presentedPassword, String actualPassword){   // Custom method for the integrity check (standard library) in Spring Security's context or applicationContext file if you are using annotations only like @Autowired and not via xml configuration files 
         return passwordEncoder.matches(presentedPassword,actualPassword);    // Use Bcrypt against presented passphrase with actual stored hash   Matcher is a part of Spring Security's context or applicationContext file if you are using annotations only like @Autowired and not via xml configuration files 
     }     
}