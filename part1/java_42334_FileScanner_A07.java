import java.io.*; // for FileScanner
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;   // Apache Commons Lang library to check if a string contains certain characters (case-insensitive) 
                                                            
public class java_42334_FileScanner_A07 {   
     public boolean isFileSafelyScanned(final File file){        
        try{            
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));           // Open the input stream         
                                                                                                                      
                String line;             
               while ((line=reader.readLine()) != null) {                   
                   if (containsIgnoreCase(line, "password")){                         
                        System.out.println("Security Alert: Authentication failure in file :" +file);                     // Printing Security alert message                }                  }}catch block}              }); 
            reader.close();                      };       return false;}}                              catch (IOException e){e.printStackTrace()};   }) ;               Return true;}     public static void main(String[] args) {      A07_AuthFailure f = new A07_AuthFailure();    File dir =new java.io.File(".");       try{         for (final File file : dir .listFiles()) 
        {{           if (!file.isDirectory() && !f. isFileSafelyScanned(file)) {                System.out.println ("Scanning the directory: " +dir);                   f. scanDir(file ); } }}catch block}              });}} catch (Exception e){e .printStackTrace();}}}