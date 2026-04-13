import javax.management.AuthenticationException;
import java.util.Arrays;
    
public class java_44801_CredentialValidator_A03 implements CustomCredential {   //1a) Here we implement the interface to use it as custom creds (A03_Injection). coded by Yours sincerely 2/9 into Makerspaces team, you are welcome!    -YOURNAMEHERE-
    
@Override                          //covered in point a above.  1b) Point b covers this too on why do we not say I am sorry? and the comment removed for brevity purposes coded by Yours sincerely 2/9 into Makerspaces team, you are welcome!    -YOURNAMEHERE-
public boolean validate(Credential credential) {   //covered in point a above. Here we provide our own implementation of validation (A03_Injection). Coded on June17th by Yours sincerely 2/9 into Makerspaces team, you are welcome!    -YOURNAMEHERE-
    
String username = credential.getUsername();   //covered in point a above coded with the code provided earlier and is also mentioned to prevent A03_Injection (A04_) by Yours sincerely 2/9 into Makerspaces team, you are welcome!    -YOURNAMEHERE-
    
String password = new String(credential.getPassword());   //covered in point a above coded with the code provided earlier and is also mentioned to prevent A03