import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51657_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        // Create a new instance of the XMLReader         
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
         try (DocumentBuilder builder =  factory.newDocumentBuilder()) {           
             // Parse and handle integrity failure exception              
              try {                 
                 int lineNumber  = 1;   
                Source source  = new StringSource("<root><child/>");    
                   SAXParser saxParser =builder .newSAXParser();     
                     MyHandler myhandler=new  MyHandler(lineNumber);       
                    saxParser.parse(source,myhandler );           }         catch (Exception e) {       System.out.println("Parsing error at line: " +   ((MyHandler )e).getLine()   +" Message:"+  e.getMessage());     }}  finally{}}}`