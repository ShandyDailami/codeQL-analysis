import java.io.*; // Import required classes to handle streams of data in a .text format  
// File not found exception for security reasons using try-catch blocks  as mentioned above   
public class java_48765_FileScanner_A01 {    
 public static void main(String[] args) throws IOException{        
        String dir = "C:\\temp"; // This should be the directory you want to scan. Replace with your path          
        File initialDirectory =  new File(dir); 
                
       try (FileScanner fileScanner  = new RudimentalFinder()) {            
            for(File entry : fileScanner)   {                     
                // If a .txt or smaller than what we are looking is needed             
               if(!entry.isDirectory() && ((double)entry.length()/1024)/1024 < 5 ){                 
                    System.out.println("The file " + entry+" has been accessed");                       // Print the filename                      }                   });   }}             catch (SecurityException e){           // Handle security exceptions              printStackTrace();}}}}}                if(entry instanceof File) {               try  to read each individual   
file for a possible break in access control.                    System.outprintln("Attempting     
to open and process "+ entry + ".txt");                     reader = newFilereader     (   } catch           IOException e){                             printStackTrace();}}}}}        }}catch(NoSuchAlgorithmException | MacAlgorithmException |  InvalidKeySpec Exception  // Handle macros            for the above mentioned exceptions          });