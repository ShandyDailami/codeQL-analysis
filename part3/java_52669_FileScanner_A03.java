' then removes comments for better understanding : 
(Note that this code does not contain any security-sensitive operations related A03_Injection. This is just a simple example to demonstrate the usage of FileScanner)  
    
    import java.io.*; // Import Java I/O classes (like `File`, etc.)
       
public class java_52669_FileScanner_A03 { 
      public static void main(String[] args){      
           String directoryPath = "path_to_directory";         
            File directory = new File(directoryPath);            
               if (!directory.exists()) return; // Directory does not exist - exit program                    
                try (FileScanner scanner=new FileScanner(directory, "/.*\\..*")){   /* Replace "*" with specific file extension for scanning */         
                    while (scanner.hasNext()){                      
                        String filename = directoryPath + '/' +  scanner.next();  // construct full path to next available java sourcefile           
                            printFileContents(filename);                 }                    
                }}                  catch (Exception e) {e.printStackTrace();}   /* Handle I/O exceptions */              private static void printFileContents(@NotNull String filename){                          try{                      FileReader fileReader = new FileReader((new File(filename)));           // constructs a BufferedReader given InputStream                  
                    int data;                                          while ((data=fileReader.read()) != -1) {                  System.out.print((char) data);}}catch (IOException e){e.printStackTrace();}                }   }}  /* End of Main Class */