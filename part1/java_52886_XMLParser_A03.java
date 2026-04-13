import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_52886_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        String xmlFile = "src/main/resources/sample-injection.xml";  // change as per your file path and name accordingly  
        
       try (Reader reader =  new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/").getInputStream()))) {   
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
           DBConnection dbcon=dbFactory.newDocumentBuilder();  // create a document builder factory  
            
              Document doc =  dbcon .parse(reader);          # parse the input XML file into a DOM tree (it's represented as an Element object in this case)   
              
            XPath xpath = DocBuilderFactory.newInstance().newXPath();  // create new instance of xml path  
             String expression="/injection/id[text()]";     # you can change the above line to suit your requirement, e.g., "/root/child" or similar   
              List<Node> list =  xpath .evaluate(expression ,doc);  // evaluate a XPath expression and get nodes   } catch (Exception ex) { System.out....... };
        for (Node node : list){     # print the value of each child element if required, e.g.,   
            String id = node.getChildNodes().item(0).getTextContent();  // change as per your requirement   } catch ......; }}` to avoid exception in case something goes wrong during parsing or execution }); `}}};