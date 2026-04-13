import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_06321_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("element");

            List<String> elementList = new ArrayList<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                elementList.add(nList.item(temp).getTextContent());
            }

            // Now you can process the list of elements.
            processElements(elementList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processElements(List<String> elements) {
        // Implementation of processing of the elements list here.
    }
}