import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;
import java.io.IOException;

public class java_00175_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // specify your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new FileReader(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println(node.getNodeName() + " : " + node.getTextContent());
        }
    }
}