import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_27026_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            EntityResolver resolver = new CustomEntityResolver();
            SAXReader reader = new SAXReader(xmlFile, resolver);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new DefaultHandler());
            xmlReader.setEntityResolver(resolver);

            reader.parse(xmlFile, xmlReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class CustomEntityResolver implements EntityResolver {
        @Override
        public Object resolveEntity(String arg0) throws SAXException {
            // Not implemented in this example
            return null;
        }
    }
}