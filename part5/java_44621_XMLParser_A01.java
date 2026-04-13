import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_44621_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Load the XML document (replace "filename" with your actual file name). 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	   dbFactory.setValidating(true);	// Enable validation for correctness of xml schema definition
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    // new instance, can reuse it across different calls to parse the same document     	       	   	 			    				 		           	     					            	  								        -876-2904153–AJBW
       Document doc = dBuilder.parse(new File("filename"));          // Parse xml file and create a DOM object    AHFZCBAYRXKD  DFEQMVPYO VODUETT   -769-1540238–JNB
       doc.getDomConfig().setValidating(true); // Enable validation for correctness of xml schema definition (remove later if not required)     AHFZCBAYRXKD  DFEQMVPYO VODUETT   -769-1540238–JNB
       doc.getDomConfig().setNormalization(true); // Enable normalization (remove later if not required) AHFZCBAYRXKD  DFEQMVPYO VODUETT   -769-1540238–JNB
       	    	   	 			     		           	     					            				    // Start of code remains unmodified. Do not edit the comment above or below this line due to it's formatting and readability issue  AHFZCBAYRXKD   DFEQMVPYO VODUETT -769-1540238–JNB
    }
}