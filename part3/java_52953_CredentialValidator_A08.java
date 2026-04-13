import javax.validation.*;
import java.util.*;
  
public class java_52953_CredentialValidator_A08 {    
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();  //1a          
      
    public Set<ConstraintViolation<String>> validatePassword(final String password) {       
          Validator validator =  this.factory.getValidator().forClass(String.class);        
          return validator.validate(password);   }     
    
public static void main (String[] args){    //1f      
CredentialValidator cv = new CredentialValidator();       
Set<ConstraintViolation<String>> violations =  cv.validatePassword("examplePass"); 
for (ConstraintViolation v : violations) {             System.out.println(v); }     if(violations.isEmpty()){           //1e      
System.out.print ("All constraints satisfied for password: " +"successful validation!" );   }}