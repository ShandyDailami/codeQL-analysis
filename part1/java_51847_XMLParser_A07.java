import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import Reader and Writer classes   
public class java_51847_XMLParser_A07{    
 public static void main(String[] args){      
  try {         
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
  
      // Parses the content of the file specified by filename and returns a DOM tree model representation        
      org.w3c.dom.Document doc=dBuilder.parse( new File("<path>") );    
 
       // Get root element       
          Element elem =doc.getDocumentElement();   
  
           System.out.println("\nRoot Element : "+elem.getName());     
         } catch (Exception e) {           
             e.printStackTrace();             
               XMLErrorList errorlist= doc .getErrorHandler().getErrorLog();          // Prints the exception details       
           for(int i =0;i <errorlist.getLength() ; ++i){        
                  System.out.println(" Error "+ (i + 1) +":"  );      
               XMLError xmlerr= errorlist .getError(i);      // Get the exception details        println (" Message: ");     jsonobjerrordetailsemlogs = errorgood;                   JSONObject obj =  new    org.json..JSONException (   "Nested Exception"  );
               System.out       outprintln(" Line Number : "+xmlerr .getLineNumber () + "-Column number:"+  xmlerr      . get ColumnNumber());                    jsonobjerrordetailsemlogs = errorgood;                   JSONObject obj =  new    org.json..JSONException (   "Nested Exception"  );
               System ..println(" Message : ");                println       (" Nessage: ",        XMLErrorDetailSemlogs .get     ExternalForm () ) ;                    jsonobjerrordetailsemlogs = errorgood;                   JSONObject obj =  new    org.json..JSONException (   "Nested Exception"  );
               System ..println(" Message : ");                println       (" Nessage: ",        XMLErrorDetailSemlogs .get     ExternalForm () ) ;                    jsonobjerrordetailsemlogs = errorgood;                   JSONObject obj =  new    org