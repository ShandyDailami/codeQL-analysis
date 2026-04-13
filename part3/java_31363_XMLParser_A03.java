import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31363_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new File("input.xml"));
            XMLReader xr = XMLReaderFactory.createXMLReader();
            SAXHandler sh = new SAXHandler();
            xr.setContentHandler(sh);
            xr.setErrorHandler(sh);
            sp.parse(xr, new File("input.xml"));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}