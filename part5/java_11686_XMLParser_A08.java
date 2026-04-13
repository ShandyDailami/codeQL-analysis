import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_11686_XMLParser_A08 {

    public List<String> parseXMLFile(String filePath) {
        List<String> errors = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("operation");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (!(nNode instanceof Element)) {
                    errors.add("Invalid element found in file: " + filePath);
                    continue;
                }

                Element eElement = (Element) nNode;
                String operation = eElement.getAttribute("name");

                if (!operation.equals("A08_IntegrityFailure")) {
                    errors.add("Encountered non-security-sensitive operation: " + operation + " in file: " + filePath);
                }
            }
        } catch (Exception e) {
            errors.add("Error parsing file: " + filePath);
            e.printStackTrace();
        }

        return errors;
    }
}