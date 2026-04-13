import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class java_46958_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	      		 	 	     									     	   			        } ;             	        if (args.length != 1){System . out . println ("Usage: java XmlReader file"); System . exit (- 1);}
    public java_46958_XMLParser_A01() throws ParserConfigurationException, SAXException{ParsingConfigur c = new  										ParsingConfig();c	. setDoNamespaces(true) ;	}     protected void parseFile (String filename) { FileInputStream in  = null; try {in=new 			   		     	  Filename . java:filename);
	    DocumentBuilderFactory dbFactory = 						       Factory. newInstance() ;	dbFacto   lyory =										(DocumentBuilderr)         dbfactory	. getDocumentBuilder();        //parse the xml file into a DOM tree     D            oMDoc  = docbuilder . parseXSD(new   		     	  XmlReader (in)); 
	    System.out." parsing file: " + filename; } catch  			                                                    	          Exception e){System.. out ..println("error processing the xml file ");e.printStackTrace();} finally {try{if ( in != null)      									     close(in);}} 
    public void parseStringXML(){ try           System .out." parsing string";              ParsingConfig c = new  			           	 			ParsingConfi;          c.setDoNamespaces(true)) ; DOMDocument d = 	    Factory().newDOMSource((InputStream)c); 
    }      public static void main (String[] args){XMLParser p  =					    				           NEW XMLPARSER()；p .parseFile("testfile1")        			p. parseString();}}`;