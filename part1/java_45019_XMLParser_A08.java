import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_45019_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{       
         parseAndVerify("A08_IntegrityFailure1", "knownGoodXML");      
         // Add more test cases here if needed... 
           System.out.println("\n\tTest passed successfully!");     
    }  
     public static void parseAndVerify(String xmlFile, String knownGoodXml){       
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
          DocumentBuilder builder = factory.newDocumentBuilder();            
           // Parse XML document and get its root element 
           Document doc=builder.parse(ClassLoader.getSystemResourceAsStream("/"+xmlFile));      
           
     /* Remove the following line, if you want to print out all tags in parsed xml */  
         System.out.println("\nParsed XML :");   
          prettyPrint((Element)doc);  // Pretty printing of Document object     
           StringBuilder sb = new StringBuilder();      
            /* Save the content from "knownGoodXml" into a string builder 'sb' */    
             BufferedReader br=new BufferedReader(new StringReader (""+xmlFile));       
               for(String line;  null != (line  =br.readLine()); )      {         sb.append(line);          }       // Append the content of 'knownGoodXml' into string builder   "sb"    
            /* Compare and verify if it is equal to xml file */        String knowngoodxmlcontent =new String();   
               DocumentBuilderFactory dbFactoryKnow = DocumentBuilderFactory .newInstance ( );     
             Document docKG=dbFactoryKnow.newDocumentBuilder().parse( new InputSource(  sb ));         // Parsing the string builder 'sb' into a XML document        knowngoodxmlcontent    =doc K G    .getElementsByTagName("students").item(0).getTextContent();    
           /* Throw an exception if there is any difference between parsed version and "knownGoodXml" */       assert xmlFile.equalsIgnoreCase (knowngoodxmlcontent);      else throw new IntegrityFailure ("Integrity failure in the XML file:"); }   // If not identical, then this will print out error message           
        static void prettyPrint(Element elem) {     Document doc = null;         if ((doc=((Document)elem.getOwnerDocument()))==null){             System.err .println ("Unable to acquire document from Element.");}  else for (Node node  =  0 ;node !=  null;) {        Node next   =      node           
                 .getNextSibling();     if ((next=(Element) next)) doc =       elem;         }    System.out                      // Print out all tags in XML tree          printTags("",elem);}  static void           (   public abstract class Printer {        protected String tabs ;     
                 final                boolean isIndentationRequired, requiresEndTag ,requiresStarttag     = null             currentElement        =null;    }catch(Exception e){printStackTrace();}} catch            (IntegrityFailure exception)           {}   // Catch the Integrity Failure Exception if there are any differences in XML