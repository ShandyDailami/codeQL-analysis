import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

public class java_16839_XMLParser_A08 {

    public static void main(String[] args) {
        String url = "http://example.com/config.xml"; // replace with actual URL
        parseXML(url);
    }

    public static void parseXML(String url) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(url);

            // Here you can use the document for further processing
            // ...

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}