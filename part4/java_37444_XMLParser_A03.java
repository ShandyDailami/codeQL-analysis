import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_37444_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "input.xml";
        String elementName = "elementName";
        parseXMLFileAndExtractValues(xmlFile, elementName);
    }

    public static void parseXMLFileAndExtractValues(String xmlFile, String elementName) {
        File inputFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName(elementName);

            for (int temp = 0; temp < nl.getLength(); temp++) {
                System.out.println(((org.w3c.dom.Element) nl.item(temp)).getAttribute("value"));
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}