import java.io.*; // Import of built-in functionalities for IO operations in form IOException and InputStream 

public class java_49734_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{    
        String filePath = "/path/toYourFile";      // replace with your actual path, relative or absolute based on requirement.      
         try (InputStream input = new FileInputStream(filePath))  {          
            int data;            
              while ((data=input.read()) != -1)                  
                System.out.print((char)data);   // Prints each character of the file in order, one by one        
        } catch (FileNotFoundException e){    /* If File Not Found exception occurred */     
            System.err.println("The application was unable to find and load your specified file: " + filePath ); 
             throw new Exception(e); // Throwing the caught exceptions in a higher level way of handling it for further debugging purposes   }     catch (IOException e) {    /* If IO exception occurred */        System.err.println("An I/O error has occurred: " + filePath ); 
            throw new Exception(e); // Throwing the caught exceptions in a higher level way of handling it for further debugging purposes   }       catch (Exception e) {    /* If any other exception occurs */        System.err.println("An unexpected problem with your program has occurred: " + filePath ); 
            throw new Exception(e); // Throwing the caught exceptions in a higher level way of handling it for further debugging purposes   }     finally{      if (input != null) input.close();}}    /* Closing statement */        System.out.println("Ended processing file: " +filePath ); 
            }} `