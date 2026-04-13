import java.io.*; // Import the necessary classes to work with Files/Directories, etc...  
public class java_47834_FileScanner_A01 {   
       public static void main(String[] args){     
             File file = new File("C:\\Users");    
              scanFilesInDirectoryRecursively (file);  // Call method here         
        }        
           private static void scanFilesInDirectoryRecursively(File directory) {   if (!directory.exists()) return;    try{       for (String fileName : directory.list()) {      File newFile = new File((directory.getAbsolutePath() + "\\"+fileName));    
         // If the current item is a folder, then recurse into it       
               if(newFile.isDirectory()) scanFilesInDirectoryRecursively (newFile);   else {       String nameOnly = newFile.getName();      int lastDotPosition = 0;    for (;;)  {     // Loop until we find the '.txt' part of file extension       
               if(nameOnly.indexOf('.',lastDotPosition) == -1 ) break;}   else{       String extention = nameOnly.substring(lastDotPosition+1);      System.out.println("File found: " + newFile +  "\t Extension is :"+  extention );}}catch (Exception e){}     }    }}