import org.apache.xml.security.utils.SecurityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_42044_XMLParser_A03 {

    @SecuritySensitive
    public String parseXml(String filePath, String elementName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document;
        try {
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // Handle exceptions here
            e.printStackTrace();
            return null;
        }

        document.getDocumentElement().normalize();
        Element element = (Element) document.getElementsByTagName(elementName).item(0);

        if (element == null) {
            System.out.println("Element not found!");
            return null;
        }

        return element.getTextContent();
    }
}