import java.io.*; // Import required classes from Java libraries or frameworks like IO, NIO etc.   
class java_48223_FileScanner_A08 {    
public static void main(String[] args) throws IOException{     
       File dir = new File(".");              # Current Directory               
        printDirs(dir);                      # Call the method to list sub-directories  
}                                           # End of 'main' function         
                                            
private static void printDirs(File directory) {  // A recursive helper Method            
    if (directory.listFiles() == null){        # If there is no file, return      
      System.out.println("Empty Directory " +   # Message for the user to understand        
          direction .getPath());               # What's being checked             
     } else {                                  # Otherwise do this                   
             File files[] = directory                      # Get all Files in current dir       
                 .listFiles();                         # Loop through each file           
    int i = 0;                                # Count for looping  
          while (i < files.length){               # Start of the 'while' loop        
              if(files[i].isDirectory() && !".".equals(files[i].getName())  ){     # If it is a directory, skip "..", and only print its name  
                  System.out.println("D: " + files[i].getPath());                   # Print the Directory Name   
                 } else if (!"..".equals(files[i].getName())) {                      # Else Skip it               
                     try{                                                                     
                       FileReader fr = new FileReader(directory+"/"  +  file.          getName() );                    setFilePermissionExceptCurrentUserAndGroupReadOnly();                          }              catch (Exception e){                            System.out.println("Error reading: " + files[i].getPath());}               
                 i++;                                                                     # Increase looping counter       
             }} ; printDirs(directory);                                                };   try { setFilePermissionExceptCurrentUserAndGroupReadOnly();}} catch (SecurityException e)  {}                  }          '''' )'; this code is for security sensitive operations related to A08_IntegrityFailure.'# Remove the comment.