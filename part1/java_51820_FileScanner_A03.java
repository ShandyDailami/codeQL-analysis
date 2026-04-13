import java.io.*; // Import required classes  
public class java_51820_FileScanner_A03 {    
    public static void main(String[] args) throws IOException, SecurityException{     
        String directoryPath = "/path/to";      
          
          /* Create a new file object for the input stream */ 
         try (FileStream fis = new FileInputStream((new File(directoryPath)))){  
             // Declare an array to hold characters read from the file.   
            char[] chars = new char[fis.available()];     
              /* Reads character by character into buffer */ 
               try (BufferedReader br =  new BufferedReader((new InputStreamReader(fis)))){     // Create a buffering character input stream  
                    String line;   
                       while ((line = br.readLine()) != null) {      /* Reads a line of characters */       System.out.println("File content: " + (char[]) chars);}})} catch(Exception e){  // Catch exception if any   }     finally{System.out.print("\n Closing BufferedReader");} }}