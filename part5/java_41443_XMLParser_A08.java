import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_41443_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new File(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getNodeName());
        }
    }
}