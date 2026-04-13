import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_35879_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            File inputFile = new File("input.xml");
            parser.parse(inputFile, new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String currentElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElementName = localName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            currentElementName = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (currentElementName != null) {
                System.out.println(currentElementName);
            }
        }
    }
}