import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28102_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler myHandler = new MyHandler();

            saxParser.parse(inputFile, myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTag = false;
        String tag = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bTag = true;
            tag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bTag = false;
            tag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bTag) {
                String data = new String(ch, start, length);
                System.out.println("Tag: " + tag + ", Data: " + data);
            }
        }
    }
}