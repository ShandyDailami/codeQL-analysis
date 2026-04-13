import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("credentialValidator") // Define as a Spring Bean named "CredentialValidator" 
public class java_50028_CredentialValidator_A03 {  
     private final PasswordEncoder passwordEncoder;    // Dependency Injection for BcryptPasswordEncoder (A02_Security) via Constructor @Autowired.
     
     public java_50028_CredentialValidator_A03(PasswordEncoder passwordEncoder) {  this.passwordEncoder=passwordEncoder;}   /* Spring's Bean Initializer */ // Avoid using final variable as constructor argument in a non-final field initializers, or use the '@PostConstruct'. Also avoid declaring any of your fields static and effectively final - otherwise you can’t initialize them during bean instantiation.
     
     @Autowired  /* Injecting via Constructor */   // Dependency injection for DatabaseAccess using HibernateTemplate (A03_Injection). Spring's Bean Initializer is used to inject the database access object into this class when it’s created by spring. Avoid directly instantiating any of your fields which are supposed be set up in a constructor and then manually call methods on those field objects inside constructors using @Autowired or Constructor Injection, otherwise you will run against yourself with NPE exceptions during bean creation time due to late static variable initialization issues (also called ‘static field init’).
     private final HibernateTemplate hibernate;    // Dependency injection for DatabaseAccess via constructor. Spring's Bean Initializer is used here too but this doesn't work with fields which are supposed be set in a Constructor Injection, and then manually call methods on those field objects inside constructors using @Autowired or Autowire by name