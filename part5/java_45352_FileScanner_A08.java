import java.io.*;   // Import File and Directory APIs   
class java_45352_FileScanner_A08 {     
     public static void main(String[] args) throws IOException{      
          String directoryPath = "/path/to/directory";          
          scanDirectoryForErrorFiles(new File(directoryPath));           
     }        
            
   // Method to recursively traverse directories and print all .txt files which contain the string 'error' 
    public static void scanDirectoryForErrorFiles (File directory) throws IOException {     
        for (File file : directory.listFiles())         
              if(file.isFile() && containsStringInFile("error", file))             // Checking .txt files only  
                  System.out.println ("Found error in: " + file);          
                                 
       File[] subDirectories = directory.listFiles();                         
        for (File subDirectory :  subDirectories)                             
            if(subDirectory.isDirectory())                                        // Checking directories recursively  
                scanDirectoryForErrorFiles (subDirectory);                     
    }              
          public static boolean containsStringInFile (String searchStr, File file) throws IOException {     
              BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));             // Reading the text in .txt files 
                String line;                                                     
                  while ((line = reader.readLine()) != null){                     // Checking each line for 'error'  
                    if (line.contains(searchStr))                           return true;}                  
                 reader.close();                                                // Closing the BufferedReader after use 
             return false;                                                      }                       public static void mainMethod() {      System . out . println ("This method is not accessible");}    }}