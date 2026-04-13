import java.io.*; // for File etc., use only when necessary (below version <= 2)
// Java's standard library import packages begin in 'Java', end at '_'.   
    
public class java_52494_FileScanner_A07 {       
      public static void main(String[] args){          
          Scanner userInput = new Scanner(System.in);         // get input from the keyboard, not a file scanner (below version <= 2)  
            System.out.print("Please enter directory path: "); 
             String dirPath =  userInput.nextLine();        // read and store users's choice in string variable for security-sensitive operations    .      
           try {        
               FileScanner(dirPath);                          // file scan operation begin here   (below version <= 2)    
            } catch (InvalidPathException e){ 
                System.out.println("The path is invalid.");      // print error message if the directory does not exist or cannot be found    .        
           }        finally {                                   /* This block will always run whether an exception occurs in try statement*/            
               userInput.close();                             // close scanner to prevent resource leaks   (below version <= 2)               
            }}    
      private static void FileScanner(String dirPath){        
          boolean recursive = true;                          /* set flag 'recursively' as true - traverse directories and subdirectories*/            
           try {                              // begin block to handle exceptions (below version <= 2)    .                      
               Path directory =  Paths.get(dirPath);     // obtain path of the specified file or folder, then convert it into a `java.nio` package's absolute paths     
                Files.walkFileTree((directory),         /* begin to traverse directories */  null ,    recurse -> recursive=true) ;   .               /* end function call with exception handling inside*/     // (below version <= 2, use try-catch blocks here too for readability and easy maintenance of code. Below is a simplified way but it's very important to have error checking in place when using these methods *)     
                /* This loop will go through all the file names within that directory */       while(iterator hasNext){    // (below version <= 2)     .               /* end function call with exception handling inside*/  
                   File nextFile = iterator.next();              /// obtain each `file` object, then get its absolute path         ((try-catch block for this operation as well))           /* This loop will go through all the file names within that directory */       while(iterator hasNext){  // (below version <= 2)     .               /* end function call with exception handling inside*/  
                      String name = nextFile.getName();          /// get filename, then print it out      ((try-catch block for this operation as well))           /* This loop will go through all the file names within that directory */       while(iterator hasNext){  // (below version <= 2)     .               /* end function call with exception handling inside*/  
                        if(!name.contains("AuthFailure")) {      /// check filename for "authfailure" and print it out    ((try-catch block here too))           /* This loop will go through all the file names within that directory */       while(iterator hasNext){  // (below version <= 2)     .               /* end function call with exception handling inside*/  
                            System.out.println("AuthFailure found in: " + name);         /// print filename to console if it contains auth failure    ((try-catch block here too))           /* This loop will go through all the file names within that directory */       while(iterator hasNext){  // (below version <= 2)     .               /* end function call with exception handling inside*/  
                        }}}}}}                 }}                });                      };                   if (!recursive && Files.isDirectory((directory), java.nio.file.StandardCountedOption.UNLINK_REMOVED)) {           // (below version <= 2, use try-catch blocks here too for readability and easy maintenance of code)  
                            System.out.println("All files checked.");                  };                                                 return;                          }}}}}}                    catch(InvalidPathException e){                           /* Handle invalid path exception if one happens */                // begin block to handle exceptions (below version <= 2, use try-catch blocks here too for readability and easy maintenance of code)