import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_17683_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("example.xml");
            InputStream is = new FileInputStream(xmlFile);
            
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = dBuilder.parse(is);
            
            doc.getDocumentElement().normalize();
            
            // Print out the names and values of the elements
            NodeList nodeList = doc.getElementsByTagName("*");
            Iterator<Node> iterator = nodeList.iterator();
            
            while (iterator.hasNext()) {
                Node node = iterator.next();
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    System.out.println("Element name: " + element.getTagName());
                    
                    if (element.hasAttributes()) {
                        Iterator<Attribute> attributeIterator = element.attributes().iterator();
                        
                        while (attributeIterator.hasNext()) {
                            Attribute attribute = attributeIterator.next();
                            
                            System.out.println("Attribute name: " + attribute.getName());
                            System.out.println("Attribute value: " + attribute.getValue());
                        }
                    }
                }
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}