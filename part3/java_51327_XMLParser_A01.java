import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_51327_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Step 1: Load XML file using DocumentBuilderFactory and parse it with DOM API (Step a & b). We'll use the built-in one for simplicity.
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	    
         String xmlFilePath="src/datafile.xml";  // Step f, replace this file path as per your requirement  		   
        try {			      									     	       
            XMLReader reader =  factory.newXMLReader();         	   	 	     							                            } catch (ParserConfigurationException e)	{	    						        									}                System.out.println("Problem in parsing the file"+xmlFilePath); return;  // Step c, if xml parser throws exception then we can't continue further   
            									     	       			  		         	   	     	 							           }else {                           	    						       printElementData(doc,"");} });                 };         System.out.println("End of Parsing"+xmlFilePath);  // End Step a, if no exception then we can continue further                            
    private static void printElementData(Node node){     	   		         									       	    	if (node instanceof Element) {  			           Document doc = null; try{doc=node.getOwnerDocument();}catch (NullPointerException e ){} 	 	      }}}); }} catch (ParserConfigurationException | TransformerException  | IOException ex37){ System.out.println("Issue in creating transformer "+xmlFilePath +" :Caused by: " + 
     				ex38 .getMessage()); return;};  									     try{TransformerFactory tf = TransformerFactory	.newInstance(); 		   	    if(tf==null) {System.out.println("No support for transforming the document into PDF");return;} DocumentWriter writer=	tf     
                 				getAccessToElement(".//data", null,true); //replace "./data" with your XML file data path and name of element you want to print   } catch (TransformerConfigurationException e) {System.out.println("Issue in creating transformer :Caused by: 	" +e .getMessage()); return;};}}catch(IOException ex4){ System.out.println ("Error occurred while reading the file"+xmlFilePath);return;} });
    }    									     	      		            try {doc = reader.getDocument();} catch (SAXException e) {} };  // Step c, SAX parsing is not allowed for this exercise so we'll just use DOM Parser in the end   System.out.println("End of Document read"); }
    	catch(PullParserException ex5){System.err.print("\nError occurred while reading file"+xmlFilePath);return;}  // Step c, if exception is raised then we'll return to step a as per the instructions  					    }; System.out.println("End of Parsing"); }
};