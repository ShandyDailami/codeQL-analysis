import java.io.*; // Import Java I/O classes for handling files and directories 
import javax.security.auth.Subject;   /* For security sensitive operations */   
class java_50347_FileScanner_A01 {    
      public static void main(String[] args) throws IOException{          
        String directoryPath = "your_directory";      
         System.out.println("Reading all the files in folder and subfolders.");  // Prints out starting message for clarity of code  
            FileScanner fileReader= new VanillaFileScanner();     /* Create an instance */   
             try {     
                 if(fileReader instanceof SecuritySensitiveOperations){       /** Checking whether it is a security sensitive operation or not*/ 
                      ((SecuritySensitiveOperations)fileReader).performAccessControlOperation("A01_BrokenAccessLevel"); /* If yes, then perform the access control */      }   else {     // Else just read files    File[] files = ...;       for (File file : files){ 
                     if(file.isDirectory() || (!Files.exists(Paths.get(directoryPath + "/"+ file.getName())) ){ continue;} /** If it is not a directory, skip */   else {     // Else proceed with reading    }      try (Stream<String> lines = Files.lines(fileReader)) 
                         /* Read the text from files and print them out on screen for simplicity of code example*/       System.out.println("\nFile Contents: " + file.getName());                
                     lineIterator : while (lines.iterator().hasNext()) {   // Loop through lines in each File    String nextLine = ...;  if(!nextLine.isEmpty()){ continue;}     /* Skip empty files */      System.out.println(nextLine); }}}} catch (SecurityException | BrokenAccessLevel e) {}
        /** End of the try-catch block for exception handling **/   }}    // Main method's end here  FileReader class has been used to read file contents but is not a standalone program in this context, so it was skipped. */     }}}}}}