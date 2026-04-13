import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02427_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        DefaultHandler handler = new DefaultHandler();

        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser sp = spf.newSAXParser(new org.xml.sax.InputSource(new java.io.FileInputStream(xmlFile)));
            sp.setEntityResolver(new org.xml.sax.ext.EntityResolver() {
                public java.io.InputStream resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                    return new java.io.FileInputStream(systemId);
                }
            });

            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(handler);
            xr.parse(new java.io.FileInputStream(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}