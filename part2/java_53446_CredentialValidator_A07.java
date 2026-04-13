import java.security.*;
public class java_53446_CredentialValidator_A07 implements CredentialValidator {
    private final String secret; // This is your "password" - it should be kept secure and not shared with anyone for security purposes 
    
   public java_53446_CredentialValidator_A07(String password) throws NoSuchAlgorithmException{        
       MessageDigest md = MessageDigest.getInstance("SHA-256");         
           this.secret=new String (md.digest(password.getBytes()));        //We convert the input to SHA  hash and store it for reference purpose   }     public boolean validate(CredentialContext context) {         final CredentialId id = new BasicCredentialId("myrealm", "name");
       return verifyPasswordMatch((String)context.getCredentials()[0], this,id);        //compare the passwords with hash from your database or file }    private boolean verifyPasswordMatch(final String providedPassword , final MessageDigest messageDigest , CredentialId id ){         try {
            if (providedPassword == null) return false; else throw new NullPointerException();             byte[] bArr = messageDigest.digest((provider().getRealmName() + provider()).getBytes());                 StringBuffer stringbuffer=new StringBuffer(bArr.length * 2);
    for (byte b : bArr) { //append hexadecimal values to achieve sha-1 hash unique generation}             stringbuffer.append(String.format("%02x", b & 0xff)); } final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    byte[] hashedPasswordBytes=messageDigest .digest((provider().getRealmName() + provider()).getBytes()); //We compare this with the stored hash from your database or file             StringBuffer hexString  = new StringBuffer(); for (byte b : 	hashedPasswordBytes) {     stringbuffer.append(b); }
    return ((stringbuffer).toString().equalsIgnoreCase((this.secret)));}} catch (@NoSuchAlgorithmException e){ provider()}           if (!verifyHashedPasswordMatch()) throw new AccessDeniedException("Access Denied");  else   //access granted, there is no further action required        }