import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class java_17044_XMLParser_A03 {

    public List<String> parse(String xmlFilePath) throws Exception {
        List<String> results = new ArrayList<>();

        // Create DocumentBuilderFactory and DocumentBuilder instances
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the XML file and get a Document object
        Document doc = dBuilder.parse(new File(xmlFilePath));

        // Get the root element of the document
        doc.getDocumentElement().normalize();

        // Get all 'country' elements
        NodeList nList = doc.getElementsByTagName("country");

        // Iterate over each 'country' element
        for (int temp = nList.getLength() - 1; temp >= 0; temp--) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            // Get the value of the 'name' element
            String countryName = eElement.getElementsByTagName("name").item(0).getTextContent();
            results.add(countryName);
        }

        return results;
    }

    public static void main(String[] args) {
        try {
            XmlParser parser = new XmlParser();
            List<String> countries = parser.parse("countries.xml");
            for (String country : countries) {
                System.out.println(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}