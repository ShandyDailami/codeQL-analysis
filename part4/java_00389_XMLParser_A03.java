import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXSource;
import java.io.File;
import java.io.IOException;

public class java_00389_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // replace with your xml file
        parse(xmlFile);
    }

    private static void parse(File xmlFile) {
        SAXSource saxSource = null;
        XMLReader xmlReader = null;

        try {
            saxSource = new SAASource(xmlFile);
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.setErrorHandler(new MyErrorHandler());
            xmlReader.setEntityResolver(new MyEntityResolver());
            xmlReader.parse(saxSource, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (saxSource != null) {
                    saxSource.close();
                }
                if (xmlReader != null) {
                    xmlReader.close();
                }
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}