import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_43243_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{    	
        // Create a new factory for the DOM configuration source and parse through it to get Document object     
	    File xmlFile = new File("sampleXML.xml");        	 		  			            									      	  						 															   	} private static void readXmlfile(String file) throws ParserConfigurationException, IOException {    	PushbackReader pr=null;          //Create a reader object        XMLReader xr = null ;     
	    DocumentBuilderFactory dbFactory = 		          			        									       BuilderFactory.newInstance();   	 	      DTDValidate dvt  =   new  SequenceValidator(dbFactory)	     {public void warning (SAXParseException e){}};               //Read XML file and save it in XmlDom object     
	    DocumentBuilder db =        			                 									       getDocumentBuilder(dvt);   		            pr=((PushbackReader)(getXMLFileAsStreamForValidation("/Users/sagarjainiitbhuwani/Documents/"+file))); xr   =db.newSAXParser();     	  
	    System.out.println("Reading XML file : " + xmlFile);    		         									      	 			  XmlLocator loc = new DomSource(pr) ;        //Read the content of given location            Document doc  =xr .parse (loc,dvt );              	//Print all element in 'employees' tag     
	    Element rootElement=doc.getDocumentElement();    		         	      									                     NodeList nodeLists =rootElement.getElementsByTagName("Employee");  //Selecting employee nodes using the name of tags    for (int temp = 0;temp<nodeLists . getLength() ;++tem) {        
	    Element elem=(Element) nodeLists.item(i);    		         	      									                     System.out.println("Employee Name : "+elem.getElementsByTagName('name').item (0).getTextContent());    //Printing the name of all employees   }}};