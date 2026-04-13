import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_19598_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseXml(xmlFile);
    }

    public static void parseXml(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("note").item(0).getTextContent());

            NodeList nodeList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("Note: " + nodeList.item(temp).getTextContent());
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}