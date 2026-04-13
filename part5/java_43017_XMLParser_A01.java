import java.io.*;  // Import InputStreamReader and BufferedReader from the 'read' package  

public class java_43017_XMLParser_A01 {   
     public static void main(String[] args) throws Exception{       
          try (InputStream in = new FileInputStream("untrusted_file")) {              
              int content;                      // Declare a variable for reading and handling file data. 
                                                  
                                          while ((content=in.read()) != -1){  
                                         System.out.print((char) content);      }            }}         catch (Exception ex)       {{          Logger lg = LoggerFactory.getLogger(MyXMLParser .class );    // Use slf4j logger     Loglevel can be set to DEBUG, INFO and ERROR levels 
                                   log.error("Error while reading from file ",ex);}}      }}                      }});