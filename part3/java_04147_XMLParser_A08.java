import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_04147_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParser parser = org.xml.sax.SAXParser.factory.newInstance();
        MyHandler handler = new MyHandler();
        try {
            parser.parse(new File("sample.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                System.out.println("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + attributes.getValue(0));
                bAge = false;
            }
        }
    }
}