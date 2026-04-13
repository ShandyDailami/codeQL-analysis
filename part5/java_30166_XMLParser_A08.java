import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_30166_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementNames(doc);
        } catch (ParserConfigurationException e) {
            System.out.println("Error parsing XML. Message: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML. Message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file. Message: " + e.getMessage());
        }
    }

    private static void printElementNames(Document doc) {
        NodeList nl = doc.getElementsByTagName("*");
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);
            System.out.println("Element: " + e.getTagName());
        }
    }
}