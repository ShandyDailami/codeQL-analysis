import javax.xml.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_53737_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
	factory.setValidating(true); // set it to true for testing purpose      		    
	    XMLReader xmlreader=null;  	 			   
	      try {              									 	       
              XmlPullParser parser  = factory.newPullParser();         								       
            Document doc =parser.getDocument();                      	                                       
             Node node =doc.getFirstChild();      		               
                    while(node != null){          			      // print tags              					 	       
                        System.out.println("Tag : "+ ((Element)node).getTagName());   				         	   	     								   }           	    								} catch (Exception e1) {e1.printStackTrace();} }}`;