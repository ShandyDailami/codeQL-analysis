import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_06600_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        String elementName = "element_name_to_extract"; // replace with your element name

        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            List<String> extractedValues = extractValues(doc, elementName);

            System.out.println("Extracted values: " + extractedValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> extractValues(Document doc, String elementName) {
        List<String> extractedValues = new ArrayList<>();

        NodeList nList = doc.getElementsByTagName(elementName);
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            extractedValues.add(nNode.getTextContent());
        }

        return extractedValues;
    }
}