import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_46470_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{      
           // Step1 - Load XML file into Document object  (using SAX parser for simplicity).       
          File inputFile = new File("sampleinputfile_A01.xml");  
         SAXParserFactory factory = SAXParserFactory.newInstance();    
	SAXParser saxparser=factory.newSAXParser(null);  // using default settings   
	  XMLReader xr=saxparser.getXMLReader();      
           Document doc =  xr.read(inputFile) ;   /* read and parse the input file */     
        NodeList nodeLists =doc.getElementsByTagName("*");     /// get all nodes  /////step2 - print tag names of each parsed XML element   	      		         			           	   	  }catch (Exception e){System.out.println(e);}}}}}