import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_43902_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        XMLReader reader = XMLReaderFactory.createNonValidatingXMLReader();  // Create a non-validating parser (SAXParser is used here but you can use any other parser if needed).        
         
        MyContentHandler contentHandler= new MyContentHandler(reader);      
                 
        try {            
            reader.setContentHandler(contentHandler );     // Set the Content Handler to be our own handler in case we need information about parsing process  e..g., handle errors or exceptions from SAX parser   
             
               XMLParser xmlp = new XMLParser();           ## create a class that wraps around your custom contenthandler  
            String fileName="src/data.xml";                 # path to input data source         
                   FileInputStream inStream = 		# use the Java Input Stream, you can replace this part with any other method if needed        		 				    	 			   	   	       	     					     						       fgfgff;   . -.-'-. '...-..'. ---. / '. '-..-.' `'-., .. ...`./ ',
                    '/', '', '' ,'',''';,,'|','/'}, (