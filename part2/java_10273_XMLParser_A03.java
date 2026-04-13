import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_10273_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // Replace with your XML file path
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("note");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node [" + i + "]: ");
            System.out.println("Title: " +
                    nodeList.item(i).getAttributes().getNamedItem("title").getNodeValue());
            System.out.println("Description: " +
                    nodeList.item(i).getAttributes().getNamedItem("description").getNodeValue());
        }
    }
}