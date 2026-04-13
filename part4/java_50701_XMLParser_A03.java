import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50701_XMLParser_A03 {  
    public Document getDocument(String filename) throws ParserConfigurationException, IOException{    	
        // Step1: Get the instance of parser configuration     
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
	        /*  Create a new document builder */         
            DocumentBuilder builder  = factory.newDocumentBuilder();   
	    return builder.parse(filename);   }    	      		       	 			            										}`public class XMLParserTest{ public static void main (String[] args){ try {         String xmlfile = "sample_data";  // Name of the file to parse          Document doc =  new DOMParser().getDocument("xmlfile");                   
    } catch(Exception e)        System.out .println ("Caught 'em all!"); }}`                  	      		            			  										} `catch (SAXException se){se .printStackTrace();  // Handle exception          return;}}             	  SequenceFileTokenizer st = newSequence File Tokenize     r   
      in.read(file,"UTF-8");        } catch(){ e.. println ("Cannot read file " + filename); }}`catch (Exception ex){ex .println("Caught 'em all!" ); return;}}  // Handle exception}       public static void main   {public class XMLParserTest{try    
      String xmlfile="sample_data";DocumentBuilderFactory dbFactory = DocumentBuild    er.newInstance();         XPathFactory xpathFactory   =XPathe . newInstance ();        ParsingContext pc  =dbFactor  iy.getTreatedSaxOnMalformedElementEndEvent() );     
      `catch(Exception e){e.. println("Cannot read file " + xmlfile)    return;}} } ` catch   {System . out PrintLn ("Caught 'em all!");     reutrn;} }}  // handle exception} public static void main (String[] args ){
      try       String XMLFile ="sample_data"; DocumentBuilderFactory dbFactory=DocumentBuild    er.newInstance();        XPath xpath =  ePathe . newInstanc   et(XMLFi le); ParsingContext pc  =dbFacto  iytalizedSaxOnMalformedElementEndEvent()) ;     
      `catch (Exception ex){ex.. println("Cannot read file " + XMLFile)    return;}} } catch {System . out PrintLn ("Caught 'em all!");     reutrn;} }} // handle exception}  in this case, we assume that the xmlfile is provided as a command-line parameter.