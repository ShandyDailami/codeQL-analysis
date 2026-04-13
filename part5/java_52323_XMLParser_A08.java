import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52323_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //remove the comment at start of code and make it syntactically correct Java Code     
        DocumentBuilderFactory factory = null;    
          try {      
            File inputFile=new File("input.xml");  
               System.out.println( "Parsing XML file using SAX....\n");  //remove the comment at start of code and make it syntactically correct Java Code     
              factory = DocumentBuilderFactory.newInstance();    
            SAXParser saxParser=factory.newSAXParser();   System.out.println(saxParser);      
               MyHandler myHandler = new  MyHandler(); //remove the comment at start of code and make it syntactically correct Java Code      Handler is not used here, just a placeholder         
            saxParser.parse(inputFile,myHandler );   System.out.println("Done parsing..");    } catch (IOException e) {      
              // handle I/O exception  Here we are doing nothing for now as per the request     
             };     factory = null; }}//end of main method here is no where comment added at end due to its syntactically correct Java code.       `  ^__^=(0_0)    (oo)\_______/o  /\_________.-'\_\///         '\/\       ''''.