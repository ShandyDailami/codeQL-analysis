import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_29865_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getElementsByTagName("tag").item(0).getTextContent());

            NodeList nList = doc.getElementsByTagName("tag");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                System.out.println("Tag : " + nList.item(temp).getNodeName());
                System.out.println("Value : " + nList.item(temp).getTextContent());
            }

            doc.getDocumentElement().normalize();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}