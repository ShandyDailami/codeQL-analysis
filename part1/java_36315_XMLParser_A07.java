import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class java_36315_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start Element: " + qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        private void printAttributes(Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute " + (i + 1) + ": " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), MyHandler.class.getMethod("startElement", String.class, String.class, String.class, Attributes.class).getDefaultValue(MyHandler.class.newInstance()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}