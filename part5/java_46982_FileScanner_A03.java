import java.io.*; // Import necessary classes for file handling operations  
    
public class java_46982_FileScanner_A03 {   
      public static void main(String[] args) throws IOException{      
          File root = new File(".");// Assume the current directory as our starting point          
              
         try (FileScanner scanner=new FileWalker().walkAndOpen("/"))  // Start file walk and open it for scanning  
             {     
                 while(true)   
                     printDirectoryListingLineByline();                 
             }       
          catch(Exception ex){           System.out.println("Error:"+ex);}           
     }}