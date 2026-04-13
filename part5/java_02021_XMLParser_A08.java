import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_02021_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("test.xml"));
            doc.getDoctype();
            printElement(doc.getElementsByTagName("student"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            printElement((Element) nodes.item(i));
        }
    }

    private static void printElement(Element element) {
        System.out.println("Student Name : " + element.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Student Age : " + element.getElementsByTagName("age").item(0).getTextContent());
        System.out.println("Student City : " + element.getElementsByTagName("city").item(0).getTextContent());
    }
}