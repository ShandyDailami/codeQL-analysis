import java.io.*; // Importing needed classes for FileScanner, DirectoryStream etc...  
public class java_46372_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to/directory";  /* Insert your path here */         
       try (DirectoryStream<File> stream = 
                Files.newDirectoryStream(Paths.get(directoryPath))) {            
            for (File file : stream){                        
                 if (!file.canRead() || !file.isDirectory()) continue; // Skip non-files and directories          
                  FileScanner scan = new FileScanner();  /* This is a placeholder, replace it with the real code */         
             }             
        }}     catch (InvalidPathException e){            System.out.println(e);}      finally {System.exit(-1)};   // Exit program in case of error   
         public static void main2() {}  /* This is an empty method for calling the real scanner */          private java_46372_FileScanner_A07(){}}           }