import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41239_XMLParser_A01 {

    private static final String SAFE_WORDS[] = {"password", "secret", "key"};

    public void parse(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // Remove all elements
        doc.getDocumentElement().normalize();

        // If element contains sensitive word, throw exception
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String sensitiveData = eElement.getTextContent();
                for (String safeWord : SAFE_WORDS) {
                    if (sensitiveData.contains(safeWord)) {
                        throw new RuntimeException("Access to sensitive data is forbidden!");
                    }
                }
            }
        }
    }
}