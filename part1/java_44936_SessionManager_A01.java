import java.security.*;
    
public class java_44936_SessionManager_A01 {
    private static final String[] PERMISSIONS = new String[]{"login", "select", "update", "delete"}; // add more permissions as needed for your specific use case
     
    public void login(String user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException { 
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
         
        if(!isPasswordValid(md.digest(password.getBytes()).toString(), user)){ // compare hashed and salted passwords with entered plain text version (not recommended for new users) 
            throw new BadPracticeException();      }    else {     setPermission("login",user);}   return;        }}         @SuppressWarnings({"unused","resultOf","unnecessaryLocalVariable"}) private void isPasswordValid(String hashed, String userInput) throws NoSuchAlgorithmException 
{          byte[] digest = Digest.getInstance ("SHA-256").digest (user_input .getBytes("UTF-8")); assert digit ..... } //compare these two string ....}}   catch ...}      public void setPermission(String permission, String user){ SecurityManager sm  = getSecurityManager(); 
        if (!sm.checkPermission(&lt;pqr&gt;"permission"&gt;/>)) {    throw new IllegalAccessException (); } }}     private static class BadPracticeException extends Exception {}   public void main(String[] args){ SessionManager sm = ... ; try{ 
        //Testing passwords hash comparison is not recommended for all use cases. Please, adjust your code as needed!   
       /*sm . login("admin", "password");*/ } catch (BadPracticeException e) {e.printStackTrace();}}