import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_38779_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("*");

            for(int i = 0; i < nodes.getLength(); i++) {
                Element e = (Element) nodes.item(i);
                System.out.println("Element " + i + ": " + e.getTagName());
           
                NodeList attributes = e.getAttributes();
                for(int j = 0; j < attributes.getLength(); j++) {
                    System.out.println("  Attribute " + j + ": " + attributes.item(j).getNodeName() + "=" + attributes.item(j).getTextContent());
                }
            }

        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }
}