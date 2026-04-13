import org.apache.commons.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_11693_XMLParser_A03 {
    public Document loadXMLDocument(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.build(new File(fileName));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return doc;
    }

    public void parseXMLDocument(Document doc) {
        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        Element child = root.getChildNodes().item(0);
        System.out.println("Child element: " + child.getNodeName());

        // Here you can add your security-sensitive operations related to A03_Injection
    }
}