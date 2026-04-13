import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03624_XMLParser_A08 {

    public static List<String> getTagValues(String xmlFilePath, String tag) throws Exception {
        List<String> tagValues = new ArrayList<>();

        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName(tag);
        for (int i = 0; i < nodeList.getLength(); i++) {
            tagValues.add(nodeList.item(i).getTextContent());
        }

        return tagValues;
    }

    public static void main(String[] args) {
        try {
            List<String> tagValues = getTagValues("path_to_your_xml_file.xml", "A08_IntegrityFailure");
            for (String value : tagValues) {
                System.out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}