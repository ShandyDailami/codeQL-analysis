import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_14617_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml"; // replace with your file path

        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new XMLErrorHandler());

            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // DefaultHandler is a simple implementation of the SAX handler that doesn't handle any event.
    // It's used to prevent the parser from throwing an exception in case a parsing error occurs.
    private static class XMLErrorHandler extends DefaultHandler {
        @Override
        public void error(SAXException e) {
            // do nothing
        }

        @Override
        public void fatalError(SAXException e) {
            // do nothing
        }

        @Override
        public void warning(SAXException e) {
            // do nothing
        }
    }
}