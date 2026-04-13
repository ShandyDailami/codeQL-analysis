import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;

public class java_24062_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            MyHandler handler = new MyHandler();
            XMLReader xmlReader = reader.getReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File("data.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        String name = "";
        String age = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                name = localName;
                bName = false;
            } else if (bAge) {
                age = localName;
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name + ", Age: " + age);
                bName = false;
                bAge = false;
            }
        }
    }
}