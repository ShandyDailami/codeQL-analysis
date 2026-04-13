import java.io.*; // Import the Java I/O classes to work with files  
class java_46699_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = ".";      
           File folder = new File(directoryPath);     
            for (File file : folder.listFiles())  // Get all the files in this folder         
                if (!file.isDirectory() && !file.getName().equals("") &&  
                    ((new BufferedReader(new FileReader(file)))                 /* Read each line from a text-based input stream */                    
                        .readLines())                                              // Use Java 8's Stream API to filter out empty lines          
                            {                                                                         
                                System.out.println("File: " + file);  
                                     })}})}))