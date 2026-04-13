import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_11694_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sensitiveData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("data");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);

                String person = element.getElementsByTagName("person").item(0).getTextContent();
                String password = element.getElementsByTagName("password").item(0).getTextContent();

                System.out.println("Person: " + person);
                System.out.println("Password: " + password);
            }

            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}