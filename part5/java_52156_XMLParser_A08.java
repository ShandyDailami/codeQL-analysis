import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
    
public class java_52156_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        // Step1: Load the XML document – Document is a top-level container element of an xml file           
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();             
    
        try (StreamSource src = new StreamSource(       // Step2: Create Source for the XML document         
         new FileInputStream("src/main/resources/sample_file.xml"))) {     
            Document doc = dBuilder.parse(src); 
            
           System.out.println("\nElement data starting with 'A08' if exists:\n");             
        extractDataStartingWithAndPrintIfExists("a",doc,"- ");               // Step3: Use recursive method to retrieve the nodes and print their content      
     }    catch (SAXException e) {           System.out.println(e);          }}         finally {}  private static void        extractDataStartingWithAndPrintIfExists      (String startTag, Node node , String indent){   // Step4: Recursive method to retrieve nodes and print their content      
     if (node == null) return;                else {               Document d =    ((Element)  node).getFirstChild();          for( ;d !=null && "a".equals(((Element)         d ).getTagName());        // Step5: Start the loop from first child of Node      
     extractDataStartingWithAndPrintIfExists (startTag,   // recursive call until next node           if("- ".endsWith ((indent +d.toString())) )){      indent+="- "; }          d =         d .getNextSibling();}}}                finally {if(node instanceof       Element && "-".equals(((Element)     node). getTagName()    ){           
        System.out.println (indent + ((Element)(node)).getTextContent());} }}  // Step6: If current Node is End of Document print the indentation          try {PullRequest pr = new PullRequest();             pullrequestservice .     invoke(pr); } catch      ...      `