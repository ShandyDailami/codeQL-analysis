import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_14839_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml"; // replace with your path
        String elementToRemove = "element/to/remove"; // replace with the element you want to remove

        try {
            // Step 1: Parse XML
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Step 2: Remove Element
            NodeList nodes = document.getElementsByTagName(elementToRemove);
            for (int i = 0; i < nodes.getLength(); i++) {
                nodes.item(i).getParentNode().removeChild(nodes.item(i));
            }

            // Step 3: Save changes
            document.getDomConfig().normalizeDocument();
            document.write(System.out);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}