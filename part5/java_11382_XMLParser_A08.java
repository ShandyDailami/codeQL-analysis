import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class java_11382_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("yourfile.xml"));

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element " + element.getTagName() + " has attribute " + element.getAttribute("name") + " with value " + element.getAttribute("value"));
            }

        } catch (ParserConfigurationException | SAXParseException | SAXException e) {
            e.printStackTrace();
        }
    }
}