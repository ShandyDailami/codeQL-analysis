import java.io.*;   // for the IOException exception   
public class java_51306_FileScanner_A07 { 
     public static void main(String[] args) throws IOException{
        String directory = "/path/to";       // Replace with your path here, e.g., /home/user/documents or C:/users...  
         File folder = new File (directory);   
         
           if (!folder.exists()) {    
               System.out.println("Directory does not exist!");  return; // If directory doesn't exists, exit the program     
            }        else{      
              printFilesInFolder(folder) ;   };        
                   
             public static void printFilesInFolder (File folder){     File[] listOfFiles = folder.listFiles();    if (listOfFiles != null ) {           for (int i = 0; i < listOfFiles.length -1  ;i++      ){          // This loop prints all the file names  
                  System.out.println( "File Name: %s".formatted(listOfFiles[i].getName()));     }         };        if(!folder.canRead()){       printAccessDenied();}//If user does not have read permission, notify    about access denied and exit program      return;};  
             public static void  printAccessDenied(){System.out.println("Sorry but I am unable to list the files due Access Denied"); };         }     }}` END OF CODE