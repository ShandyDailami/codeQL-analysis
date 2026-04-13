import java.io.*; // For FileInputStream and IOException   
public class java_52108_FileScanner_A08 {  
     public static void main(String args[]) throws Exception{     
        String directory = "/path/to/" ;// Specify your own path here          
         scanDirectoryForTxtFiles (directory);         
       }  private static boolean isValidFileExtension ( File file, final String extension ) {   // Check if the filename has a certain Extension    return getMimeType(file) .endsWith("." +extension );     },      ".txt")} else{System.out.println ("The specified path does not point to an existing directory or is no correct location."); }
  private static String scanDirectoryForTxtFiles (String dirName){   // Scan a Directory for '.txt' files    File[] fileList  = null;try {fileList =     new File(dirName).listFiles();} catch(Exception e) {}for       int i = 0 ;i < fileList.length  ;     ++       
 if (isValidFileExtension((Object)fileList[i],"txt")){   // If the filename is a '.tx't     System.out .println("Text File Found : "+(new java.io.File(dirName + "/"   +  fileList [ i ].getName())).toString());}
return null; }      catch (Exception e){System out        `enter code here`(.printStackTrace() );}} }}