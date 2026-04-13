import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52751_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String inputFile = "inputfile";  // replace with your file name and path here     
		// Read the XML document:         
		 try (InputStream is = new FileInputStream(new File(inputFile))) {   
              DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
			   SAXParser saxParser=dbFactory.newSAXParser();  //Initialize SAX Parser     
             HandlerClass handler =  new HandlerClass();      
			saxParser.setContentHandler(handler);   
              saxParser.parse(is, handler );     } catch (FileNotFoundException e) {  
            System.out.println("Input file not found: " + inputFile+e);  // replace with your filename and path here      }}         public class HandlerClass extends DefaultHandler{@Override protected void startElement    ... A08_IntegrityFailure related code omitted for brevitiy...