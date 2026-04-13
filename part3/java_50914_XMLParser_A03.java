import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50914_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   //Step A1_Security-Sensitive operation: Create a document builder factory object and set security exceptions disabled in this instance    
	dbFactory.setValidating(false); 	//To prevent DOM parser from validating the DTD or XML Declaration      			   		     									       	   	 							  														 //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled             Step B1 : Create a new document builder object, passing in our DocumentBuilderFactory to its constructor.
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 	//To parse the XML file into DOM hierarchy  					   		     //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled			      Step C : Retrieve a Document object from an HTML document and use this as your work horse	
        Document doc = dBuilder.parse(new File("example.xml")); 	//To read the XML file into DOM hierarchy   //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled			   		     Step D : Get a list of all child nodes in this document and print them out	
        doc.getDocumentElement().normalize();					     				      									//To prevent recursive calls to getChildNodes if the root node's text content is changed, step C above   //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled 			   		     Step E : Get all element nodes
        NodeList nList = doc.getElementsByTagName("*");					     				      									//To get a list of elements in this document, step C above   //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled 			   		     Step F : Print out the data from each node
        for (int temp = 0;temp < nList.getLength();temp++) {					     				      									//To access and print nodes in list, step E above   //Step A2_Security-Sensitive operation: Set Security Exceptions Disabled 			   		     System.out.println("Node " + (int)((Element)nList.item(0)).getLineNo()+" : \t\t");
        }					     				      									//To print out nodes in list, step F above   //Step A2