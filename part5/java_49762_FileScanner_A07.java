import java.io.*;  // Import necessary classes such as File and FilenameFilter    
public class java_49762_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{     
        if (args.length == 0){         
            System.out.println("Please provide directories to scan.");           return;  }      
              for(final File file : new File(args[0]).listFiles() ) {               // Iterate over each item in the list of files               
                    if (file != null && (!file.isDirectory())   && ((new File("A07_AuthFailure") ).exists())){    System.out.println("\n"+ file); }           }}  catch(Exception ex){      // Catch any exceptions that may occur        return;}}