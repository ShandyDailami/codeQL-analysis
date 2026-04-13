import javax.xml.parsers.*; // Import for XML Parser, Namespaces etc..
import org.w3c.dom.*;   // Dom and Document types (used below)     
import java.io.*;     // Input/Output Streams   
public class java_49794_XMLParser_A03 { 
 public static void main(String[] args){       
try{           
// Create a new parser        
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();          
dbf.setValidating(true);      /* Enable validation */                  // Validation is optional    
DocumentBuilder db = dbf.newDocumentBuilder();             
  
/*  This tells the document builder to process annotations, CDATA sections etc*/                  
db.setFeature("http://xml.org/sax/features/external-general-entities", false);    /* Disable external general entities */     // Optional but useful for complex XML structures             
  
/* Turn off entity expansion when parsing text nodes or comment  (handling whitespace)*/       
db.setFeature("http://xml.org/sax/features/external-entity-includes", false);      /* Disable external entities */     // Optional but useful for complex XML structures      
  
Document doc = db.parse(new SourceResource("inputfile.xml"));               
doc.getDomConfig().setExpandEntityReferences(false);                      // Turn off entity expansion             
System.out.println("\nData from input file:");     
printNodeInfo(null, null , 0,(Element) doc );                        /* print the document data */  
}catch (ParserConfigurationException pce){         System.err . write (" Parser Configuration exception " +pce);             }           catch (SAXException se ){       //handling SAX Exception          if(se instanceof  DOMErrorInfo d_e) {    /* display the error information */
System.out.println(" Error at line: "+d_e .getLineNumber());               System.err . write (" XML File read exception" + se); } catch (IOException e){     // handle I/O exceptions      };         
  void printNodeInfo(String prefix, String infix , int level, Element node) {        /* Recursive method to display the info */         if ((node != null)) ;       else return;   System.out .print (prefix);    for (int i = 0 ;i <infix+ "(" +level++  +")"     + 
if(null== infix) nodeName = new String [1];           //assigns the string to an array element        if (!nodeHasChildNodes()) return;         NodeList children=     null,nodesToPrint   =   0 ;  try {   nodes  = (Node[] ) malloc.getType().cast(children);      } catch
{       System . out. print (" Error in Casting " );           //handle exception for casting and memory allocation issue */        if ((nodeHasChildNodes()) && (!isLastElement())) return;         else nodeName = new String[2];   try { children= (Node[] ) malloc     .getType().cast(children);      } catch
{       System.out.println("Error in Casting");                  //handle exception for casting and memory allocation issue */          Node childnode =  getChildNodes() [i] ;         printNodeInfo   ((prefix + "---"),infix, level ,childnoded)    };  /* call recursive method to display the data*/
} }}}`; This program will parse an XML file named inputfile.xml and output information about it using vanilla methods only (no external frameworks or libraries). The parsing is done in a minimalist style, focusing on security-sensitive operations related A03_Injection topic.  If the XPath expression doesn't exist inside your xml document then you might face an error i/e SAXException so it should be handled and if there are I/O exceptions like reading file or writing to a disk etc., they will handle by catching IOException in try-catch block .