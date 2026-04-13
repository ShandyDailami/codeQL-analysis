import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_43929_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException{
        String xmlFile = "src/main/resources/sampleXMLfile"; //Change to your XML file location in resource directory 
        
		//1. Parse the input document into a Document object:  
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   		       			            				      	 	     					              	       ​      //2 Create an instance of XML Parser 						         	        	//3 Deserialize the document (Load & Store in DOM)  								             	} catch(ParserConfigurationException pce){ System . out . println (" Invalid xml configuration "); }catch(){System.out.println("Error: "+e);}
        Document doc = dBuilder.parse(xmlFile ); // Parse input from the file and store it into DOM 		     					         	        	 				//4 Create a new TransformerFactory object  				           {}}} catch (TransformerException ex)	{System . out . println ("Invalid transformation configuration " +ex);}
                }catch(ParserConfigurationException pce){ System.out.println(" Invalid xml parsing:  ");}}   	         			            	 		            }}                                                                       	}   Catch block for exceptions and printing appropriate error message {}}} catch (TransformerException ex)	{System . out . println ("Invalid transformation configuration " +ex); }
      try{ // Transform the document into an Output using a transformer: 1. Source Document, Compiler-friendly input   2.'OutputStream' object , compiler friendly and 'Writer'-object with new features like encoding etc  3.) XML source to write in bytes or string format    4) Resulting output (Target Node), parameters for Transformer
       { try{ // Creates an instance of a transformer, the most important part here is creating input Document 2. A DomDocument object that represents 'input' data and where we apply transformations  3.'Writer'-object with new features like encoding etc   4.) Resulting output (Target Node), parameters for Transformer
        { // Call transform method to print/ write in console the final xml file after transformation: Parse result back into an XML source, store it as a string or save out on disk. } catch(TransformerException ex){System .out.println ("Invalid transformer : "+ex);}  }}catch (IOException e) { System .err . println("Error writing to File" +e );}}