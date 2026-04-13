import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_40083_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/injection_attack.xml"; // Specify your XML file path here

        File xmlFile = new File(xmlFilePath);
        try (InputStream inputStream = new FileInputStream(xmlFile)) {
            parseXmlFile(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(InputStream inputStream) {
        try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            XmlInjectionHandler handler = new XmlInjectionHandler();

            parser.setContentHandler(handler);
            xmlReader.setContentHandler(handler);

            parser.parse(new InputSource(reader));
            xmlReader.parse(new InputSource(reader));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}