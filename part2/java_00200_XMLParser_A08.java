import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AbstractHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_00200_XMLParser_A08 {

    public static void main(String[] args) throws IOException, SAXException {
        File xmlFile = new File("sample.xml");
        SAXReader reader = new SAXReader();
        Handler handler = new Handler();
        XMLReader xmlReader = reader.getXMLReader(handler);
        xmlReader.parse(xmlFile);
    }

    static class Handler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
            System.out.println("Start element: " + qualifiedName);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) {
            System.out.println("End element: " + qualifiedName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }
    }
}