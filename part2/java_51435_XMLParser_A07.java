import java.io.*;   // Import the necessary Java library class java_51435_XMLParser_A07    
       import javax.xml.* ;    // Required for parsing XML data     
public class XmlParser {       
// Function to parse a simple xml file          
static void readXMLFile(String filename)          throws ParserConfigurationException, IOException{        
   File inputFile = new File(filename);      
     DocumentBuilderFactory dbFactory   =    DocumentBuilderFactory.newInstance();     
  // Create the document builder using DOM parser factory       
DocumentBuilder dBuilder  =dbFactory .newDocumentBuilder() ;            
// Parse and load XML file          DatatypeConfigurator   dt = new   datatypeconfigu ration ();              Document doc =  dBuilder.parse(inputFile)  // Parsing the data of xml to document      System.out.println("Root element : " +doc .getDocumentElement().getNodeName() );
}     }    public static void main(String[] args){   try {        readXMLFile ("sample_file1036592784AUTHENTICATION-FAILURE") ;  // call the function and pass filename as argument to parse xml file.      }} catch (ParserConfigurationException e)         { System .out println("Failed parsing configuration ");    }catch( IOException e ){  
     system outprintln ("failed reading input" +e);}`enter code here `  // Catch block for IO exceptions and printing the error message to console.      }}// Main method ends