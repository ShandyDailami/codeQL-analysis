import java.io.*; // Import BufferedReader for reading input files from disk, FileNotFoundException if no such resource exists  
public class java_53048_XMLParser_A03 {    
    public static void main(String[] args) throws IOException{      
        String filePath = "/path/to/yourfile";  /* Provide the correct path of your XML file */        
      try (BufferedReader reader =  new BufferedReader(new FileReader(filePath))) {            
            int event;           // for xml parsing         
                    while ((event=reader.read()) != 1);   // read and ignore all but the first character   
        } catch (FileNotFoundException e)  {}                 /* handle file not found exception */                 
      System.out.println("Done.");               
     }                  
}