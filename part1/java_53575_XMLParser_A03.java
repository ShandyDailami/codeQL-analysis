import java.io.*; // Import File I/O classes  
import javax.xml.parsers.*; // Required for XML parsing    
import org.w3c.dom.*; // DOM (Document Object Model) API required by the parser   
import org.xml.sax.*;  // SAX(Simple API for XML), used to parse xml content  

public class java_53575_XMLParser_A03 {
	public static void main(String[] args){        	    		      	 	       	     	   			         										}        public Document loadXMLDocument (File file) throws ParserConfigurationException, IOException   	{      SAXParser parser = new SAXParser();  //Create a SAXPArser to parse the xml content  
             return parser.parseDocument(file); }    	 	      			public void traverseThroughNodesInElementTree(Node node){          NodeList children=node.getChildNodes()    for (int i = 0;i<children.getLength();+++) {       	    if 	(children .item(I).getNodeType ()== Node.ELEMENT_NODE )      		{     	       	 		   printElementInfo((Element) children	. item(J));     }         }} public void main (String args[]){          try{           File file = newFile("src/samplefileA03_Injection");             Document doc=loadXMLDocument(file);    traverseThroughNodesIEnetreeNodeTree(doc.getElementsByTagName ("*"));} catch 	    {              System .outprintln (“An error has occurred and cannot be retrieved..” );      }}}