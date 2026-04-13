import java.io.*; // Import File and IOExceptions
public class java_42803_XMLParser_A03 {  
    public static void parse(String file) throws IOException{    
        BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(file)));// Create a buffering character input stream 
         try {            
            String line; // A string to hold each XML node          
              while((line=reader.readLine()) !=  null){               
                  System.out.println("Parsing: " + line);                
                   }         
        reader.close();     
    }}   catch (IOException e) {  /* Exception Handling */         // handling I/O exceptions          
       printStackTrace(e );     return;              
} finally{            System.out.println("Closing the XML file");                closeFile() ;}}                  }                       private void openXmlfile(){try             ( BufferedReader reader = new BufferedReader …      catch         // exception handling           { e .printStackTrace();                     }}          return;