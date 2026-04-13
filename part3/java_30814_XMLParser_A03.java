import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30814_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler(inputFile));
        try {
            parser.parse(inputFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content = new StringBuilder();

        private File file;

        public java_30814_XMLParser_A03(File file) {
            this.file = file;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ("content".equals(qName)) {
                System.out.println(content.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content.append(new String(ch, start, length));
        }

    }
}