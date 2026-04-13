import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_10743_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.xml";  // replace with your file path
        File file = new File(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("element_name"); // replace "element_name" with the name of the element you want to extract

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Value of element " + (i + 1) + ": " + nodeList.item(i).getTextContent());
        }
    }
}