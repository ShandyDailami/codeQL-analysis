import java.io.*;  // Import FileInput/Output streams  

public class java_50937_XMLParser_A08 {    
    public static void main(String args[]) throws Exception{        
        String xmlFile = "sample_data.xml";      
          int lineNumber = 0;            
           BufferedReader br  = new BufferedReader (new FileReader  (xmlFile));   // Reads text from an InputStream   
            System.out.println("Starting parsing...");    
               String st = "";     
                while ((st=br.readLine()) != null){      
                    lineNumber++;         
                       if(lineNumber % 2 == 0)   // We are considering even numbered lines as tags        
                            System.out.println("Tag : " + new String ( st));    }              };    
        br .close();      PrintWriter pw = null;} });