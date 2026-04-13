import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_25707_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            parseXmlFile("example.xml");
        } catch (FileNotFoundException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String fileName) throws FileNotFoundException, ParserConfigurationException, SAXException {
        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(file);

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("element");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element #" + i + ": " + nodeList.item(i).getTextContent());
        }
    }
}