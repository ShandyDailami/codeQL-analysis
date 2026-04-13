import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.logging.Logger;

public class java_07941_XMLParser_A08 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("person");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);

                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();

                logger.info("Name: " + name + ", Age: " + age);
            }

        } catch (Exception e) {
            logger.severe("Parsing failed: " + e.getMessage());
        }
    }
}