import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReader.UncaughtExceptionHandler;

import java.io.File;
import java.io.IOException;

public class java_41738_XMLParser_A03 {
    private static final String FILE_PATH = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        File xmlFile = new File(FILE_PATH);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        XMLReader xmlReader = saxParserFactory.newSAXParser(new DTDHandler()).getXMLReader();
        xmlReader.setContentHandler(new ContentHandler());
        try {
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ContentHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }
    }
}