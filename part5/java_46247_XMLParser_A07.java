import java.io.*;  // Import of Stream classes  
import javax.xml.parsers.*;    // For XML Parsing (Pull parsing) and XPath API's are not required for this example, they can be used in place if needed by the caller method to parse only a part or as whole document 

public class java_46247_XMLParser_A07 {  
       static String xmlFile = "src/data.xml";    // Define XML file path here    
        public static void main(String[] args) throws ParserConfigurationException, IOException{     
                readXMLFile();          }          
         private static void readXMLFile() throws ParserConfigurationException, IOException {  
                  File xmlFile = new File (xmlFile);  // Instantiate a file object by providing the path of your XML document    
                 if (!(xmlFile.exists())){    println("Sorry.. no such file " + filename+" to read"); return;}         
                   DocumentBuilderFactory dbFactory = 
                       DocumentBuilderFactory.newInstance();  // Create factory for building a new instance  
                     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      
                      Document doc =dBuilder .parse(xmlFile);    
                    doc.getDocumentElement().normalize();          printXMLFile("Data in XML file",doc, true ); }            private static void printXMLFile (String prefix , Node node, boolean indent){  if (prefix == null) {   System.out.print (" ");    else        System.out.print(prefix);}    
                     System.out.print("Start :"+node.getNodeName());      for          (int i = 0;i <            node .getChildNodes().getLength();++           i) { printXMLFile("\t",             node.getChildNodes().item         at(        ), indent);}}  else    System.out.print("End :"+node.   getNodeName()); }    
                if (prefix == null){      for          (int               j = 0;j <              doc .getFirstChild           ().getLength();++             j) { printXMLFile("\t",doc  .       getFirst         ChildNodes().item(            ),false);}} else    System.out   out.print("End :" +node      .    
                  }}}}"); // End of the entire code snippet to start with '