import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.sun.xml.internal.bind.marshaller.SAXEventSource;

public class java_23085_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        try {
            InputStream inputStream = new FileInputStream(xmlFile);
            SAXEventSource saxSource = new SAXEventSource(createXMLReader(inputStream));

            saxSource.getContentHandler().startDocument();
            saxSource.getContentHandler().endPrefixMapping("ns:sample", "ns:sample");
            saxSource.getContentHandler().startElement("ns:sample", null, "person", null);
            saxSource.getContentHandler().attributes(null);
            saxSource.getContentHandler().startElement("ns:sample", null, "name", null);
            saxSource.getContentHandler().text(new String[] { "John Doe" });
            saxSource.getContentHandler().endElement("ns:sample", null, "name");
            // Continue with the same process for all elements...

            saxSource.getContentHandler().endElement("ns:sample", null, "person");
            saxSource.getContentHandler().endDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static XMLReader createXMLReader(InputStream inputStream) {
        Properties props = new Properties();
        props.setProperty("http://xml.org/sax/static", "true");
        return XMLReaderFactory.createXMLReader(props, inputStream);
    }
}