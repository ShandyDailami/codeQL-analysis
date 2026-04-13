import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_04636_XMLParser_A03 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        String filePath = "yourfile.xml"; // replace with your XML file path
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new FileInputStream(file));
        } catch (FileNotFoundException e1) {
            logger.log(Level.SEVERE, "File not found: " + filePath, e1);
        } catch (IOException e2) {
            logger.log(Level.SEVERE, "I/O error: " + filePath, e2);
        } catch (ParserConfigurationException e3) {
            logger.log(Level.SEVERE, "Parser configuration error: " + filePath, e3);
        }

        // Verify the document
        if (doc != null) {
            logger.info("Document " + filePath + " is successfully parsed");
        } else {
            logger.info("Document " + filePath + " could not be parsed");
            return;
        }

        // Print out the names of all the elements
        doc.getDocumentElement().normalize();
        logger.info("Root element: " + doc.getDocumentElement().getNodeName());

        Element root = doc.getDocumentElement();
        logger.info("Printing element names:");
        printElementNames(root);
    }

    public static void printElementNames(Element elem) {
        logger.info("Element: " + elem.getNodeName());

        // Recursive call for child elements
        for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
            Node node = elem.getChildNodes().item(i);
            if (node.getNodeType() == Node.TEXT_NODE)
                continue;

            // Print out the name of the element
            logger.info("Child element: " + node.getNodeName());

            // Recursive call for the child element
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElementNames((Element) node);
            }
        }
    }
}