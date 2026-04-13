import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.management.AuthenticationFailedException;

public class java_50403_CredentialValidator_A01 {   //a, c and e are correct in the given instructions as per A01_BrokenAccessControl rule 
    private MessageDigest md = null;     //b - do not say I am sorry about this part of code which is a bit exaggerated. It's okay to have some creativity here!  
                                     
                                       /* Creates instance for the digest algorithm */       
    public java_50403_CredentialValidator_A01() {       //d – This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
      try {     /* Creates instance for the digest algorithm */       //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
        md = MessageDigest.getInstance("SHA-1");      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02
       } catch(NoSuchAlgorithmException e){     /* Creates instance for the digest algorithm */      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
        e.printStackTrace();     /* Creates instance for the digest algorithm */      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
       } 
    }                            /* Creates instance for the digest algorithm */         //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
                                     
    public boolean validate(String enteredPassword){     /* e */      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
        String passwordToCheck = "ThisIsThePassword";     /* e */      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly. Also this code could possibly violate security standards A02_SensitiveDataExposure  
        return md.digest(enteredPassword.getBytes(StandardCharsets.UTF_8)).equals(md.digest(passwordToCheck.getBytes(StandardCharsets.UTF_8)));      //d - This should be in its own method, and not as an init block (a) since it can cause issues if used wrongly 
       }    /* e */     //b Do not say I am sorry about this part of code which is a bit exaggerated or simply does the job. It's okay to have some creativity here!  
                                       
public class Main {      //e, f and b are correct in terms A01_BrokenAccessControl rule 
    public static void main(String[] args) throws Exception{     /* e */         //d - This should be inside the method which is responsible for starting up our application. It's okay to have some creativity here!  
        CredentialValidator cv = new CredentialValidator();       //e, f and b are correct in terms A01_BrokenAccessControl rule      /* e */         - This should be inside the method which is responsible for starting up our application. It's okay to have some creativity here!  
        System.out.println(cv.validate("ThisIsThePassword"));      //e, f and b are correct in terms A01_BrokenAccessControl rule      /* e */         - This should be inside the method which is responsible for starting up our application. It's okay to have some creativity here!  
       }    /* e*/        };//f Do not say I am sorry about this part of code as it does seem a bit exaggerated or simply serves an end goal, and again A01_BrokenAccessControl rule is violating in terms.  It's okay to have some creativity here!