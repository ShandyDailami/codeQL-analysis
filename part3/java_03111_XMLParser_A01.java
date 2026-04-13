import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_03111_XMLParser_A01 {
    private static final Logger LOG = Logger.getLogger(XMLParser.class.getName());

    public void parse(String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(fileName));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            printTags(document);

            inputStream.close();
        } catch (IOException e) {
            LOG.severe("Failed to read file: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            LOG.severe("Failed to configure parser: " + e.getMessage());
        } catch (SAXException e) {
            LOG.severe("Failed to parse XML: " + e.getMessage());
        }
    }

    private void printTags(Document document) {
        Element root = document.getDocumentElement();
        printTags(root);
    }

    private void printTags(Element element) {
        System.out.println(element.getNodeName());
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            Element child = (Element) element.getChildNodes().item(i);
            printTags(child);
        }
    }
}