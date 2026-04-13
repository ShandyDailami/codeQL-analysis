import java.io.*; // For File I/O Operations   
implicit import javax.xml.*;// XML parser library     
public class java_46408_XMLParser_A03 {    
static void parseXMLfile(String filename) throws ParserConfigurationException, IOException{        
DocumentBuilderFactory factory = DocumentBuilderFactory .newInstance();       
factory.setValidating(true); // Enable validation         
    try (FileReader reader =  new FileReader((filename))) 
      {       XMLParser parser=   factory.newDocumentBuilder().parse(reader );           
           System.out.println("XML file successfully parsed");     }         catch (SAXException ex)        {             Logger logger = java.util.logging .Logger.getLogger(Main.class.getName());             
logger.log(ex);         
System.err.println ("File " + filename +  " is not found.");       return;  }}     public static void main (String args []) throws ParserConfigurationException, IOException {      parseXMLfile("sample.xml"); }   }