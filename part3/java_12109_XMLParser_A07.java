import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12109_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(defaultHandler);

            saxParser.setProperty(javax.xml.parsers.Feature.Names.VALIDATE_SCHEMA, false);
            xmlReader.setFeature(javax.xml.parsers.Feature.Names.NAMESPACE_SUPPORT, false);
            xmlReader.setFeature(javax.xml.parsers.Feature.Names.VALIDATE_CONTENT, false);
            xmlReader.setFeature(javax.xml.parsers.Feature.Names.UNCOLLATED_TEXT, true);
            xmlReader.setFeature(javax.xml.parsers.Feature.Names.COALESCENT, true);

            File xmlFile = new File("src/main/resources/test.xml");
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}