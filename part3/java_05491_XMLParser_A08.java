import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_05491_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path/to/your/xml/file.xml";
        parseXMLFile(filePath);
    }

    private static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(filePath));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("*");

        System.out.println("Starting XML Parsing");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("\nNode : " + (i + 1));
            System.out.println("Tag : " + nodeList.item(i).getNodeName());

            if (nodeList.item(i).getAttributes().getLength() > 0) {
                System.out.println("Attributes : ");
                for (int j = 0; j < nodeList.item(i).getAttributes().getLength(); j++) {
                    System.out.println(
                            nodeList.item(i).getAttributes().item(j).getNodeName() + " : " +
                            nodeList.item(i).getAttributes().item(j).getTextContent());
                }
            } else {
                System.out.println("No attributes");
            }
        }

        System.out.println("\nEnd of XML Parsing");
    }
}