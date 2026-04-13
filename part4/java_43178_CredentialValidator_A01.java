import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.management.InstanceAlreadyExistsException;
import sun.misc.BASE64Encoder;

public class java_43178_CredentialValidator_A01 {  //a start point for your program, it should have 'main' function in which the logic will be written to make sure legacy style is followed    }   private String userInputPassword ;     private byte[] storedHashVersionByteArray[];       public static void main(String args[]) throws NoSuchAlgorithmException {      //storing inputted password for later use          CredentialValidator cv = new CredentialValidator();        System.out.println("Enter the Password: ");         userInputPassword=System.console().readLine() ;