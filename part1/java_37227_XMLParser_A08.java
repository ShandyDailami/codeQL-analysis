import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;
import java.io.File;
import java.io.IOException;

public class java_37227_XMLParser_A08 {

    public static void main(String[] args) {
        SAXDriver saxDriver = new SAXDriver();
        File xmlFile = new File("A08_IntegrityFailure.xml");

        try {
            saxDriver.setXmlReader(XMLReaderFactory.createXMLReader());
            saxDriver.getDocumentBuilder().setValidationScheme(null);
            saxDriver.setFeature("http://xml.org/sax/features/external-parametric-entity-refs", false);
            saxDriver.setFeature("http://xml.org/sax/features/namespaces", false);
            saxDriver.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            saxDriver.setFeature("http://xml.org/sax/features/xml-version", false);
            saxDriver.setFeature("http://xml.org/sax/features/validation", false);
            saxDriver.setFeature("http://xml.org/sax/features/xinclude", false);
            saxDriver.setFeature("http://xml.org/sax/features/direct-modification", false);

            saxDriver.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}