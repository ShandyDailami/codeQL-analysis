import java.io.*;
import java.nio.file.*;
import java.security.*;
public class java_53221_FileScanner_A08 {  //begin main method   
        public static void checkFileIntegrity(Path path) throws NoSuchAlgorithmException, IOException{    
            MessageDigest md = MessageDigest.getInstance("MD5");   /// Use MD5 for checking file integrity in this instance     
           try (InputStream fis = Files.newInputStream(path)) {       // Read and send content from the input stream to digest         
                byte[] buffer = new byte[1024];        
                    int nread = 0;       
                        while ((nread = fis.read(buffer)) >= 0)   {            .   
                             md.update(buffer, 0 , nread);               // Update the message digest with content read from file          }           catch (NoSuchAlgorithmException e){             System.out.println("Unknown algorithm: " + e );       return;      }}         finally{        PrintMessageDigest(md) ;}}    
private static void PrintMessageDigest(MessageDigest md )throws  NoSuchAlgorithmException {    // Method to print the MD5 hash code of file   System.out .println("MD5: " + hexadecimalformatofTheMD5(md));}      privatestaticString hexadecimalformatofTheMD5 ( MessageDigest md) throwsNoSuchalgorithmexception{     StringBuffer hexstring = new  stringbuffer();        for(int i=0;i<mdf.digest().length ; ++I){          
            hexstring .append( Integer..toString(( md. digest()[i] &#34;X") + " ") );       }    return hexString.ToString ();  }}     public static void main method}{   //begin the program        try {      checkfileintegrity("sampleFile");} catch exceptions{System . out.println ("Error checking file integrity: ");}}