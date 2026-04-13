import java.io.*; // Import the necessary library for I/O handling  
class java_51637_FileScanner_A08 {    
    public static void main(String[] args) throws IOException, SecurityException{        
        String directoryPath = "/path_to_your_directory";     
          FileScanner fileSearcher= new FileScanner(); // Instantiate a class object      
           System.out.println("Integrity Check Starts");   
            if (fileSearcher instanceof SecurityCheck) {            
                ((SecurityCheck) fileSearcher).start(directoryPath);             
               } else{                     
                   throw new UnsupportedOperationException();  // Error handling in case of un-support operation  
        }}           System.out.println("Integrity Check Ends");    });     };      `