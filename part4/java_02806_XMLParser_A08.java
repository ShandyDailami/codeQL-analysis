import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02806_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parse("src/main/resources/example.xml");
    }

    private void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(file));
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String qName = "";
        private int qLine = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = qName.replace("}", "");
            bName = (qName.equals("name")) ? true : bName;
            bAge = (qName.equals("age")) ? true : bAge;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            qName = qName.replace("}", "");
            if (bName) {
                System.out.println("Name: " + qName);
                bName = false;
            }

            if (bAge) {
                System.out.println("Age: " + qName);
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            }

            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}