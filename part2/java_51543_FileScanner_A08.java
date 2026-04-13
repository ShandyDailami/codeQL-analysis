import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_51543_FileScanner_A08 {   // define the main program with same name as Java file, but without public java_51543_FileScanner_A08(as in A08_AccessDenied) 
    private static final String MD5 = "MD5";     // for md5 hash calculation and comparison we use this algorithm. You can switch to SHA-1 or any other if necessary  
     
    /** Main method */      
    public static void main(String[] args){           
        File fileToCheck= new File("path_to_yourFile");  // define your directory here, replace path with the actual location of a .txt files you want to scan. (A08 AccessDenied)  
           if(!fileToCheck.exists() || !fileToCheck.isDirectory()) {              System.out.println("Please provide an existing and readable file as input!");    return; }         
        checkFileIntegrity(fileToCheck,MD5 );               // call method for integrity checking            
      }           
     /** Method to calculate the md5 hash of a string in one-way way operation */ 
       private static String getMD5HashString(final File file , final MessageDigest digest) throws NoSuchAlgorithmException {           System.out.println("Checking MD5 Integrity");        try (InputStream fis = new FileInputStream(file))   //try with resources to automatically close files    
       {              byte[] buffer = new byte[1024];            int bytesCount = 0;          MessageDigest md = digest ;             while ((bytesCount = fis.read(buffer)) != -1)           {                  md.update(buffer, 0, bytesCount);}        }   catch (IOException e){      System.out.println("Error processing file integrity check"); throw new RuntimeException(e);    }}
     /** Method to compare the calculated hash with provided hashes */       private static void checkFileIntegrity(final File inputfile , String md5Hash) {           try{              MessageDigest md = MessageDigest.getInstance("MD5");             getMD5HashString (inputfile,md);         System.out.println ("Input File Integrity Check: MD5 Hash of file " + inputfile.getName()+" is OK." );}         
       catch(NoSuchAlgorithmException e){           //catch the exception if any thrown above in MessageDigest    throw new RuntimeException("Error, major failure during integration check.",e);  }}}             System.out.println ("Input File Integrity Check: MD5 Hash of file " + inputfile .getName()+" does NOT match." );}