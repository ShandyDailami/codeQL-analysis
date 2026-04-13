import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26589_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            saxParser.setContentHandler(new AuthFailureHandler());
            saxParser.setEntityResolver(new AuthFailureEntityResolver());

            saxReader = xmlReader.getReader();
            saxReader.setContentHandler(new AuthFailureHandler());
            saxReader.setEntityResolver(new AuthFailureEntityResolver());

            saxReader.parse(xmlFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}