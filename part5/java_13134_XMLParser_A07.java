import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_13134_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/xml/file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Extract the element by tag name
            List<NodeList> nodeList = doc.getElementsByTagName("tag_name");
            for (int i = 0; i < nodeList.get(0).getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodeList.get(0).item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}