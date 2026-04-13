import java.io.*; // Importing necessary classes for file handling    
public class java_49903_FileScanner_A08 {   
      public static void main(String[] args) throws IOException{ 
          FileScanner fs = new FileScanner();           
           System.out.println("Reading from 'data' folder");      
        try (FileScanner scanner = 
                    new RegexpFileScanner() {   // Creating an instance of regular file scanning   
                        private static final long serialVersionUID = 1L; 
                      };      ){           
          File dir = new File("data/");               
           if (!dir.exists()) throw new SecurityException(                 "Folder not found!");              } else {                   scanner .setIncludeHiddenFiles(true) ;     }}             fs=scan;               // Begins scanning from 'readme' and other files inside the dir    for (File file : 
           if (!file.isFile()) continue;}                       System.out.println("Reading " +         fss .getName());                BufferedReader in = new   Bufferedreader(new FileReader     ("data/"+f s));              String line;                      while ((line = `in `    .. readLine() != null )) {               // Prints the content of each file            
        System.out.println("IntegrityFailure");}}                     }catch (Exception e) {}                    fs .close();}                }}