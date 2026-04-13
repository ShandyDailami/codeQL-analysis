import javax.xml.parsers.*;  // Import required classes from XML parser package   
   import org.w3c.dom.*;     // To access DOM (Document Object Model) functionalities of the xml file, for example selecting nodes by tag name or attribute value etc        
public class java_53162_XMLParser_A08 {          
static void printElementData(String filename){      
  try{         
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        // Create a factory object           
    	DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();    // Use the new document builder to parse XSD file          
  	  Document doc            =dBuilder.parse(filename);         // Parse XML from input filename              
      printElementDataRecursive(doc, "");       // Start recursion for parsing          }  catch (Exception e) { System.out.println("Parsing failed.");     return;   }}        static void printElementDataRecursive(Node node , String indent){           if (!node.hasChildNodes() && !((Document) node).getElementsByTagName("element").length==0 ){               
       System.out.println (indent + "<"+ ((Element)node).getQualifiedName ()  +  ">");          return;}      for(int i=0;i < node.getChildNodes().getLength();++i){            printElementDataRecursive((Node) node .getChildNodes().item (),indent +   "\t" ); }              System.out.println ("</"+ ((Element )node). getQualifiedName ()  + ">");  }}     
public static void main(String[] args){           printElementData("sampleInputFileA08_IntegrityFailure21647953-xmlTestXmlParsing.txt" );}}