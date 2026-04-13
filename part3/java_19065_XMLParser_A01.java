import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLReaderFactory;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19065_XMLParser_A01 {
    public static void main(String[] args) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new File("sample.xml"));
        parser.setProperty("http://xml.org/sax/tools.base", "http://xml.org/sax/test");
        parser.setProperty("http://xml.org/sax/accessExternalDTD", "file:///C:/WINDOWS/Microsoft.NET/Framework/v2.0.50727/config/neutral/p/p/SecurityRules.dtd");
        parser.parse("sample.xml", new MyHandler());
    }

    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}