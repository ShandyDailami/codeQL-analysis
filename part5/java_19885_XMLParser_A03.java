import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_19885_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.xml";
        File xmlFile = new File(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        document.getElementsByTagName("node");
    }

}