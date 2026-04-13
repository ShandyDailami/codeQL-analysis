import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15163_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(xmlFile));

            saxParser.setProperty("http://xml.org/sax/properties/external-generalized-element", Boolean.TRUE);

            saxParser.parse(new File(xmlFile.getPath()), new MyHandler());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends BasicHandler {
        private String lastElementName = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastElementName = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElementName != null) {
                System.out.println("Element: " + lastElementName + ", Text: " + new String(ch, start, length));
            }
        }
    }
}