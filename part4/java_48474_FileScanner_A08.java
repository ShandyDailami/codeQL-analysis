import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_48474_FileScanner_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException{        
        String dir = "C:\\temp"; // Provide the directory path here where files resides         
           FileScanner fscnr = new Md5FileIntegrityChecker();  
               int count=0; 
            for (final File file : fscnr.getFiles(dir)) {               
                  if (!file.isDirectory()) {                      
                        // Calculate MD5 hash of the given files                  
                         MessageDigest md = null;                    
                          try{                            
                               md=MessageDigest.getInstance("MD5");                           
                           }catch (NoSuchAlgorithmException e){                                             
                                System.err.println(e);                                         
                              return;} 
                        FileInputStream fis = new FileInputStream((file));                     
                         byte[] dataBytes = new byte[1024];                         
                             int metaData;                    
                           while ((metaData=fis.read(dataBytes)) != -1){                   
                                  md.update(dataBytes, 0, metaData);                       }                  
                            fis.close();                     
                        // Get the hash's bytes and convert it to hexadecimal format         
                         byte[] md5Bytes = md.digest();                             
                          StringBuffer sb = new StringBuffer("");                          
                                        for (int i = 0; i < md5Bytes.length ;i++){              
                                           sb.append(Integer.toString((md5Bytes[i] & 0xff) + 0x100, 16).substring(1));              }    
                         System.out.println("MD5 hash of " + file+" is: "  +sb.toString());                      return;}}}}) ;                  count++;}             if (count == 0){System.err . println ("No files found in the specified directory.");}}}  catch(Exception e) {e.printStackTrace();}