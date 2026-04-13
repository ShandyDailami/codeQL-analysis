import org.xmlparser.*; // importing the xml parser library we'll be utilizing from a previous assignment/coursework
                       // DO NOT USE ANY EXTERNAL LIBRARIES FOR XML Parsing HERE, ONLY STANDARD JAVA ELEMENTS AND OPERATIONS ARE ALLOWED. 
import java.net.*;       // imports for URL connection and socket classes to open urls in a safe manner that does not leak sensitive data such as password etc., if any are needed they should be handled by the XMLParser or other similar secure methods available within standard Java libraries only due security concerns with injection attacks 
                         // e.g https://stackoverflow.com/questions/24897561/java-xmlparser-how-to-securely-parse-with-urlconnection-or-socket    (check this link for more info on how to secure XML parsing with URLConnection or Socket)
 
public class java_42734_XMLParser_A03 {           // start of the main method, entry point into your program.
     public static void main(String[] args){        
          try{                 // begin a block that will handle any exceptions thrown within this scope (try-catch blocks can be used for exception handling in Java)  
             XMLParser parser = new SAXParser();  // Create an instance of the xmlparser. This is not using external libraries, so we only use standard java elements and operations   
              
              URL url=new URL("http://www.example.com/sample.xml");//Create a connection object for connecting to internet or any server   Here this would be your XML file source  (do replace with actual location of xml)    
            
            //create an instance and parse the given URI by creating a new SAX parser         
               HttpsURLConnection conn =(HttpsURLConnection ) url.openConnection();     
              //set request method to GET   The below line is not using external libraries only standard java elements are used here 
             int total=conn.getContentLength();   
        System.out.println(" Content-length: "+total);     /* Display the content length in bytes */       conn.connect ( );      //establish a connection to server and get response   } catch exceptions from above block, do not forget about it!  this makes sure we handle any exception that might occur within our try/catch blocks properly
          finally{             /// ensure your code will run no matter what happened in the process. This is where you close connections or resources like file handles etc., if necessary (do use a Finally block to make these operations)    }      //end of Try-Catch  and Finally Blocks        System.out .println ("XML Parsing Completed");
          }}//close main method   */ /* end here*/