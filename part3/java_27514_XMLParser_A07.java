import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.File;
import java.io.IOException;

public class java_27514_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.security.auth.failure", true);
            reader.setFeature("http://xml.security.auth.failure.unauthenticated", true);

            // Start the parsing process
            reader.setContentHandler(new XmlContentHandler());
            reader.parse(new SAXSource(new InputSource(new FileInputStream(xmlFile))));

        } catch (UnsupportedCallbackException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}