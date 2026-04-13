import java.io.*; // Importing necessary classes 
import java.security.*;   // For MessageDigest class java_45632_FileScanner_A08 get MD5 value of files    

public class FileScanner {   
      
        public static void main(String args[]) throws IOException, NoSuchAlgorithmException{     
            String folderPath = "/path/to/folder";  /* Change this path as needed */  
              
            MessageDigest md=MessageDigest.getInstance("MD5");     //Using MD5 to check integrity of files   
             File fileOrDirectoryCheckSum;      
                
                File startingDirectory = new File(folderPath);     
                  for (File file : startingDirectory.listFiles()) {  /* Listing all the Files and Directories in a Directory */  
                      if (file.isFile() && !file.canRead())    // Check whether it is not readable, which means security issue    
                          System.out.println("A08_IntegrityFailure: The file or directory " + file+" may be corrupted");  /* Print the Security Issue */  
                       else{      if (fileOrDirectoryCheckSum != null) {          // Check whether it's already been calculated    
                            byte[] fileContent = toByteArray(new FileInputStream(file));      
                                    String md5ChecksumActual =  bytesToHex(md.digest(fileContent)) ;      /* Generate MD5 Checksums */   
                                     System.out.println("MD5 checksum of "+file +" is :  " +  md5ChecksumActual);   //Print the generated Md5    
                                   } else {          FileInputStream fis = new FileInputStream(file) ;      /* Generate MD5 Cheksums */    System.out.println("Calculating checksum for: "+ file );        String  calculatedchecksum=getMD5Checksum(fis);   //Print the generated Md5    
                                }              if (calculatedchecksum .equalsIgnoreCase(md5ChecksumActual)){          System.out.println("File integrity is valid.");      /* Print File Integrity */    }}  else{System.err.println ("Unable to read file");}}}}}   catch (Exception e){e.printStackTrace();}
                }     //End of for loop and try-catch block end                    `