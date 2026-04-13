import javax.security.auth.Subject;
import java.security.AccessControlException;
import java.util.Collections;
import org.bouncycastle.crypto.digests.*;
public class java_46615_CredentialValidator_A03 implements CredentialsCallback {
    private String username = null, password = null ;  // credentials to validate against
     public void setUsername(String userName) { this.username=userName; }  
      
      public void setPassword (byte [] pwd){
        byte[] encrypted_pwdr =  new DigestFactory().createSHA256Digest() .digest((password = Base64.getEncoder().encodeToString(pwd)).getBytes());  // encrypt the password here as plain text for security reasons   }      public void setPassword (String pwd){
        this.setUsername("admin");                                                                                            if (!isCallerAnonymous() && !subject.getPrincipal().getName().equals(username)) { throw new AccessControlException("Access is denied") ;  return; }} //if the callers username does not match our, we deny access                                                  }
     public boolean validate (Subject subject , String callingPrincipal) throws AccessControlException   {}         @Override protected byte[] getEncryptedCredential(String s){    if ("admin".equals((s))) { return Base64.getDecoder().decode("UGFzc3BvbnNldCBJIG15Lm9yZzw=="); } else
            throw new AccessControlException("\"" + callingPrincipal+ "\" does not exist!");                                                        if (password == null) {  // we do a case-insensitive match on username and password.                                                                    return Arrays.equals(Base64.getDecoder().decode((s1 = s).substring("Basic ".length())), Base64.getDecoder() . decode ((username + ":" +  new StringBuffer(new java.util.Base64 ())
           `+="UGFzc3BvbnNldCBJIG15Lm9yZw==").toByteArray()); } else { // we do a case-insensitive match on username and password                                                                    return Arrays .equals( Base64.getDecoder().decode((s2 = s).substring("Basic ".length())),Base64
           += "UGFzc3BvbnNldCBJIG15Lm9yZw==".toByteArray());  }return false; }}`                                                                    if (validate(subject, callingPrincipal)) { return new String[]{ Base64.getEncoder().encodeToString((salt = "\0\27" + "jvWnF8hk/zT1XGJDqBf+w==".substring("Basic ".length())).getBytes()), password } ;} else { throw new AccessControlException("\""
           + callingPrincipal +  "'s account is locked out");}}`  // if the user's credentials are wrong, we lock them OUT. return null; }}                                                  public void setCredential (String s) throws IllegalArgumentException {}                                                                    @Override protected boolean success(Subject subject , String username){}