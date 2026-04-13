import java.io.*; // Import the needed classes 
class java_52332_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        File file = new File("C:/Users/YourUserNameHere");     
        
            String [] listOfFiles = file.list();         
            
           if (file == null || !file.exists()) {  // Check source folder does not exist or user lacks permission to access it   
                System.out.println("Source directory doesn't exists/You do not have permissions.");   return; }    
              for(String name : listOfFiles){         
                    if(!name.endsWith(".txt")) {  // Check file type and only handle .txt files       
                          File newFile = new File (file, name);   
                            System.out.println("Found the following textual data: " +newFile );      }    
                           }}                                           });}}}}}`   FYI - This is a basic example of file reading which could be expanded to suit your needs like read specific lines or files (e.g., pdfs).  Please replace 'C:/Users/YourUserNameHere' with actual directory path and ensure you have necessary permissions for the program to execute correctly on that machine where it runs under user having appropriate access rights as per security best practices while writing sensitive operations in Java such code is provided below: