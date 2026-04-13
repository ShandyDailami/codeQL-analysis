import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_43690_FileScanner_A01 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);  // Reading from System Input Stream is against security best practices, but for the purpose of this example we'll do so... (Also: not recommended in a real-world scenario!)  
        
        List<String> fileList;                  /* We use ArrayList instead to remove possible NullPointerException */   
                                               // If your application must be able to handle multiple directories, then you should make it an array or Collection. 
         
                                                                                             void listFilesIn(File directory) {   // Recursive function for listing files in a Directory        
            File[] files = directory.listFiles();       /* Get all the files from that specific folder */             
                                                        if (files != null){        // Making sure we don't try and access file names of non-existing directories  - Again, not recommended for real world applications!    
                              List<File> list = new ArrayList<>();    /* Use an arraylist to store the files */         
                                  boolean allOkay;                     /* To check if there is any error during iteration over folder content (e.g., permissions issue)  - Again, not recommended for real-world applications!*/   // This should be a flag or exception handling mechanism rather than checking every single file manually as above    ...    
                                                                         ......                  else {                                                        /* If no problem occurred */          .....       }      .readFile(file);                                  );                   break;            default:                     for (int i = 0, len = files.length ;i <len && !allOkay;)  // Iterate through all the content and check permissions - Again not recommended in real-world applications!!!        try {                                                    ......                 } catch(SecurityException e)