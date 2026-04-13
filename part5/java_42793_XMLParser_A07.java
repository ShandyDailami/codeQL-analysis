import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_42793_XMLParser_A07 {  // replace 'SpringBoot' with your actual project name if it is different  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String fileName = "src/main/resources/Sample.xml";     
        
        XMLReader reader;  // Create an instance of the Reader interface         
      
        try {             
            FileInputStream fis = new FileInputStream(fileName);               
           // create SAXParserFactory   with a default security context            
            SAXParserFactory factory =  SAXParserFactory.newInstance();    
               reader=factory.newSAXParser(null, new MyHandler());      
                     
              /* parse the xml file */     
            reader.parse(fis);                 
         } catch (FileNotFoundException e) {    // Catch exception if any            
          System.out.println("Error in reading");    
           e.printStackTrace();               
        } 
       readString+=in;              
      /* write your code here for authentication failure */                 systemOutPrintWriter.*;                  println(readFromFile);    // Print the content of file         
   }}                   System.outprintln("Authorization Failure");         break;}              default:System . outprint ("Others..." + in );  }      /* write your code here for other cases */        reader=null;}}     private static class MyHandler implements DefaultHandler { // define a handler to process the xml tags   
@Override public void startDocument() throws SAXException{             System.outprintln("Start of Document");       }}            @overridepublicvoidEndElement(String uri, String localName ,  int lineNumber)throwsSAxExceptioN     {System outprint (" End Of" +localname+ "line: "  +Line number);}}         
@Override public java_42793_XMLParser_A07(string prefix," string      URL ) throws SAXException{             System.outprintln("Start of Prefix mapping:"  ); } @overridepublicvoidendprefixmapping(String uri, String    localName , int lineNumber)throwsSAxExceptioN     {System outprint ("End Of" +localname+ "line:   ",  +Line number);}}