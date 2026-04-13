import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.entities.DefaultEntityResolver;
import org.xml.sax.sanitizer.SanitizerException;

import java.io.File;
import java.io.IOException;

public class java_04819_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws IOException, SAXException {
        File file = new File(fileName);
        SAXReader saxReader = new SAXReader();
        EntityResolver resolver = new DefaultEntityResolver();
        sanitizer(saxReader, resolver);

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setEntityResolver(resolver);
        xmlReader.setContentHandler(new MyContentHandler());
        xmlReader.parse(file);
    }

    private static void sanitizer(SAXReader saxReader, EntityResolver resolver) throws SanitizerException {
        saxReader.setEntityResolver(resolver);
        saxReader.setValidation(true);
    }
}