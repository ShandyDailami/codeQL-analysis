import java.io.*;  // Import required classes for File I/O, Streams etc..    
import javax.xml.bind.DatatypeConverter;  
...      
public class java_48497_FileScanner_A08 {   
        public static void main(String[] args) throws Exception{        
            String directory = "path_to_directory"; // Put your path here     
             File folder = new File(directory);    
              if (folder.exists()){              
                    for (File file : folder.listFiles()) {                
                         System.out.println("Processing: " + file.getName());  
                          Hash hsh;// Instantiate a hash object   
                          MessageDigest md5 = MessageDigest.getInstance("MD5");  //Get an instance of the MD5 hashing algorithm    
                                  if (file.isFile()){                             
                                     FileInputStream fis=new FileInputStream(file);     
                                         byte[] buffer = new byte[1024];      
                                             int length;          
                                                 while ((length = fis.read(buffer)) > 0) {  // read data and update counter   
                                                      md5.update(buffer,0,length);   }       
                                      MessageDigest md5Temp=MD5.getInstance("MD5");     
                                         byte [] digest =md5.digest();       FileUtils utils;// create an instance of the utility class    
                                             StringBuffer hexString = new StringBuffer(); // convert bytes to Hexadecimal  
                                                 for (int i = 0;i < digest.length ;i++){ 
                              hx= DatatypeConverter.printHexBinary(digest[i] & 0xFF);    }     hexString =hx .toUpperCase(); // convert it to uppercase   HEX string representation of the above hash (hexadecimal)        utils;
                                             System.out.println("Hashcode for " + file+" : -> "+  digest );       if (!utils.){     }         else {  println ("Integrity Check Failed!");    }}      catch(Exception e){e.printStackTrace();}}   // end of the loop and error handling part