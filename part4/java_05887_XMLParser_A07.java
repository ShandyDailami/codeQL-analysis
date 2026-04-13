import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_05887_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new DefaultHandler() {
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Security-sensitive operation here
                    if (qName.equals("AuthFailure")) {
                        System.out.println("Authentication failure detected!");
                    }
                }
            });

            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}