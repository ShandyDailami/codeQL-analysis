import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_33602_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("myFile.xml");
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new MyContentHandler());
            xr.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}