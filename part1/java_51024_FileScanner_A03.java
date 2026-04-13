import java.io.*; // Import the necessary Java packages for input/output streams, paths etc...  

public class java_51024_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{       
          String directory = "/path_to_your_directory";  /* Path to your target folder */     
          
          // Create a BufferedReader for reading files from the specified path.      
          try (BufferedReader br =  new BufferedReader(new FileReader("src/main/.bak"))) {    
               String line;        
                while ((line = br.readLine()) != null){        // Reads a line of text, like this:  "text".     
                      System.out.println((char) Integer.parseInt(new StringBuilder().append(System.currentTimeMillis()).reverse().toString()));    /* Print the reverse time in millisecond */   }    
          };        // Close statement is automatically handled here, but can be done manually if needed      
      }        
}