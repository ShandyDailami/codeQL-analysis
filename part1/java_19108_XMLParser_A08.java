import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_19108_XMLParser_A08 {
    
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(XMLParser.class.getName());
        File inputFile = new File("src/input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        
        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement(), 1);
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error parsing XML", e);
        }
    }

    private static void printElement(Element element, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + element.getElementsByTagName("name").item(0).getTextContent() 
                            + " : " + element.getElementsByTagName("value").item(0).getTextContent());
        
        NodeList childElements = element.getElementsByTagName("child");
        for (int i = 0; i < childElements.getLength(); i++) {
            printElement((Element) childElements.item(i), indentation + 1);
        }
    }
}