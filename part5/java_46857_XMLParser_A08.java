import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_46857_XMLParser_A08 {
    public static void main(String[] args) throws Exception{        
        DocumentBuilderFactory dbFactory = null;   // Step 1    
        try {            
            DBConnection();       // Call the function that connects to an XML file (Step #2 and step#3).          
        } catch (Exception e){      // Catch any exceptions, print error message.         
              System.out.println(e);   
         }  finally{    
                dbFactory = null;   // Closing the connection to database server at end of program      
            }            
          
        public static void DBConnection() throws Exception {     
               URL url  = new URL("file:C:/test.xml");          try (InputStream input =  new FileInputStream(url))  {              DocumentBuilderFactory dbf = DocumentBuilderFactory .newInstance();                   DocumentBuilder dbBuilder  =  dbf.newDocumentBuilder();                      Document doc   = dbBuilder.parse(input);
                 System.out.println("Parsing XML file");    // Step #4 - print a message to confirm success of parsing       } catch (Exception e) { 
        }}         });          };           DBConnection() : Exception {}   public static void main method () throws exception{}     );             try{DBconnection();}catch(e){System.out..println("Error in connection");}}finally;dbFactory=null;}public class XmlParser:Exception { // Constructor }