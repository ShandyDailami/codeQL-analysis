import java.io.*; // Import necessary classes needed in this task; File, BufferedReader etc...
                   
public class java_49540_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{        
        String filePath = "/path/to/directory";  /* specify your directory path here */                
       // Scan for '.txt' files in the given location and print out their names.          
                    System.out.println("These are some txt (security sensitive):");              
            File dir = new File(filePath);                 
                   if (dir.isDirectory()) {                    
                        String[] listOfFiles= dir.list();                     
                            for (String fileName : listOfFiles)  {                   
                                // Security-sensitive operation related to A07_AuthFailure               
                                    try{                          
                                        FileReader reader = new FileReader(filePath + "/"+ fileName);                         
                                            BufferedReader br  =new BufferedReader (reader);                                     
                                           String line;                                        
                                             while ((line=br.readLine()) != null)  {                      // Read the contents of a '.txt'   files one by-one                             
                                                /* This is security sensitive operation related to A07_AuthFailure */                    
                                   }    br.close();                                      reader.close();                               System.out.println(fileName);                                                       }} catch (Exception e) {  // Handle exception}       finally{/* Close the connection, if it was open at all   -}}      /* Specify your directory path here*/}))        
                                  } else {               println ("The given location is not a valid Directory");                  return;    }}}