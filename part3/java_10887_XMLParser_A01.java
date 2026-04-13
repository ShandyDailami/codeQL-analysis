import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_10887_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("name");

        System.out.println("Names: ");
        for (int temp =0; temp < nodeList.getLength(); temp++) {
            System.out.println(nodeList.item(temp).getTextContent());
        }
    }
}