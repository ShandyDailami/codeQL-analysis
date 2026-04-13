import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_13721_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("name");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Name: " + nodeList.item(i).getTextContent());
        }

        nodeList = doc.getElementsByTagName("quantity");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Quantity: " + nodeList.item(i).getTextContent());
        }
    }
}