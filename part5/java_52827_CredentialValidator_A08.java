import java.security.*;
public class java_52827_CredentialValidator_A08 {  
    private MessageDigest md;       //Message Digest for SHA256 hashing algorithm     
     public String encrypt(String password) throws NoSuchAlgorithmException{        
        this.md = MessageDigest.getInstance("SHA-256");         
	byte[] hashByte  =this .md.digest(password.getBytes());       //Compute SHA  -   A single step in encryption           byte [] buffer=new String (hash).toCharArray();    return new String (buffer);              }      @Override public boolean validate(String password){         
         if(!validatePasswordEntropy((java.lang.String)password)) {        //If the entered password is not secure then it can't be validated     System.out .println ("Invalid Password"); return false;            }}  void main (final String args []) throws NoSuchAlgorithmException{         
         Credentials credentials = newCredentials();              try      {credentials.. encrypt("password1")}catch(NullPointerExceptioN e)    {}   catch     if(!validate((java.lang .String)"Password"))  System outprint ("Invalid password");}};