import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_02758_XMLParser_A08 {
    
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(XMLParser.class.getName());
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("person");
            
            for (int temp = 0; temp != nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                
                logger.log(Level.INFO, "Name: {0}, Age: {1}", new Object[] {name, age});
            }
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error parsing XML: {0}", e);
        }
    }
}