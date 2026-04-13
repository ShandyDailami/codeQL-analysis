import java.io.*; // For File I/O 
    
public class java_50163_FileScanner_A07 {     
// Start of main method        
 public static void main(String[] args) throws IOException{         
        String dir = "/path_to_directory";                     
       try (FileScanner fs = new RudimentaryFS(new File(dir).listFiles())) // Using a custom file scanner  
    {               
            while (fs.hasNext())  // If there are more files in the directory...       
             System.out.println("file: " + fs.next());         
     }              catch (SecurityException se)      
      {                     
               System.err.printf(se.getClass().getName()+" : %s%n",  //Handling security exceptions                 Secure operations will fail here           
                    Severe);    PrintWriter pw = new             OutputStreamWriter(System.out));       
          se.printStackTrace (pw );   }       return;      }}