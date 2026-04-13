import java.io.*; // Import necessary classes for file handling 
public class java_50715_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/directory";      // Path to the target directory        
          
        try (FileStream fstream = new FileInputStream(new java.io.File(directoryPath)))  {      
            DataInputStream in = new DataInputStream(fstream);             
              
            String strLine;         
             while ((strLine = in .readLine()) != null)   // Read each line of file until end        
                System.out.println (strLine);       
                     }       finally {      if (in  !=  null){ try    {     in.close();} catch(Exception e){}};}}}