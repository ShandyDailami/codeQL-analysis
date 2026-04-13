import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38138_XMLParser_A03 {

    private File xmlFile;
    private Document document;

    public java_38138_XMLParser_A03(String xmlFilePath) {
        xmlFile = new File(xmlFilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return document;
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser("path/to/your.xml");
        Document doc = parser.getDocument();
        // TODO: process XML document
    }
}