import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class java_06815_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(url.openStream());
            document.getElementsByTagName("tag");

            // Here you can perform your operations on the parsed XML document
            // ...

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}