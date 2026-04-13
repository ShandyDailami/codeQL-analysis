import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.IOException;

public class java_33710_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        String DTDFilePath = "path_to_your_DTD_file.dtd";

        EntityResolver resolver = new MyEntityResolver();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(resolver);

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            File xmlFile = new File(xmlFilePath);
            InputSource inputSource = new InputSource(xmlFile);

            reader.parse(inputSource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyEntityResolver implements EntityResolver {
    public InputSource resolveEntity(String url, String name) throws SAXException, IOException {
        throw new SAXException("Broken entity: " + name);
    }
}

class MyHandler extends DefaultHandler {
    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String name) {
        System.out.println("Start of element: " + name);
    }

    public void endElement(String uri, String localName, String name) {
        System.out.println("End of element: " + name);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}