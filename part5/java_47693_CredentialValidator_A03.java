public class java_47693_CredentialValidator_A03 {  
    public static void main(String[] args) throws Exception{       
            CredentialValidator validator = new BasicCredentialsMatcher();      
             String username, password;     
              BufferedReader br=new BufferedReader (new InputStreamReader (System.in));         System.out.println ("Enter User Name: ");    user name  =br .readLine() ; 
            //The following line can be replaced by using secure way of storing credentials in real applications, e.g., getPassword from the SecurityManager class or similar mechanism     password = br.. readline();   System."\nPlease Enter Password : "+ "\t";             String correct_password="securelystoredpasswd";     
            //String encryptedPassWord =  new  EncryptionClass().encrypt(correctPassword);    if (validator.validateCredential("username", password, userNameDB)) {          System . out .println ("Access granted!"+ "\n\t");} else{              Console.. Error ...";         }
        //...and so on for all operations related to injection attacks  A03_Injection in Java. In real world applications these should be handled by an authentication library or framework as shown above not manually using basic CredentialValidator example program   and following best practices of security you can use the Bcrypt, Argon2 etc hash functions which are a part of java standard libraries for password hashing 
        }    // End main method.     
}