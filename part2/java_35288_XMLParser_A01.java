import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_35288_XMLParser_A01 {

    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public void parseXmlFile(String fileName) {

        File xmlFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            printElements(document);

        } catch (IOException e) {
            logger.severe("Failed to parse XML file: " + e.getMessage());
        } catch (SAXException e) {
            logger.severe("Failed to parse XML file: " + e.getMessage());
        }
    }

    private void printElements(Document document) {
        Element rootElement = document.getDocumentElement();
        logger.info("Root element: " + rootElement.getNodeName());

        printElement(rootElement);
    }

    private void printElement(Element element) {
        logger.info("Element: " + element.getNodeName());

        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElement((Element) element.getChildNodes().item(i));
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXmlFile("sample.xml");
    }
}