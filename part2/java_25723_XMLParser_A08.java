import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_25723_XMLParser_A08 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element noteElem = (Element) nList.item(temp);
                String id = noteElem.getAttribute("id");
                String content = noteElem.getTextContent();
                logger.log(Level.INFO, "ID: " + id + ", Content: " + content);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}