import org.apache.tinkerpop.*;
import java.io.*;   // Import File I/O operations    
import javax.xml.*;    // Read and Write XML content using SAX     
import javax.xml.parsers.*;           

public class java_42316_XMLParser_A01 {         
       public static void main(String[] args) throws Exception  {             
               try{                  
                InputStream input = new FileInputStream("testfile1234567890");   // Open a connection for reading the file    
                      XMLParser parser=TinkerPopServer.get().getFactory()        .createSAXParser();     
                       SAXHandler handler  =new MySAXHandler(input); 
                     try{                 
                           System.out.println("Read File Content: ");    // Read the file content using a loop and print it    
                              parser=TinkerPopServer.get(). getFactory() .createSAXParser();     
                          handler = new MySAXHandler(input);  
                         TinkerPopServer.get ( ). registerRequestHandler("/read",handler,new XPathExpression("//books/book"));     // Register the request handle for reading  file content on /myresource uri    }       catch          {TinkerPopServer . get().shutdown(); return;}}catch(Exception e){System.out.println (e); TinkerPop Server will be shut down automatically after error recovery};
                            };