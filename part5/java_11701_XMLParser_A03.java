import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_11701_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        String commandForInjection = "<script>"; // command for injection

        try {
            FileInputStream inputStream = new FileInputStream(xmlFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            List<String> elementsToRemove = new ArrayList<>();

            // Find elements containing the command for injection
            NodeList elementList = document.getElementsByTagName("*");
            for (int i = 0; i < elementList.getLength(); i++) {
                Element element = (Element) elementList.item(i);
                if (element.getTextContent().contains(commandForInjection)) {
                    elementsToRemove.add(element.getTagName());
                }
            }

            // Remove elements containing the command for injection
            for (String elementToRemove : elementsToRemove) {
                document.getElementsByTagName(elementToRemove).item(0).getTextContent("");
            }

            // Print the parsed XML
            document.getDocumentElement().normalize();
            System.out.println(document.getFirstChild().getNodeValue());

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + xmlFilePath);
        } catch (ParserConfigurationException e) {
            System.out.println("Error parsing the XML file: " + xmlFilePath);
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file: " + xmlFilePath);
        }
    }
}