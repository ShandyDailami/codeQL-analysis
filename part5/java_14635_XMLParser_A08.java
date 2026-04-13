import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_14635_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReader.newInstance();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(new File("filename.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
            // Your code here to handle the start element
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            // Your code here to handle the end element
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
            // Your code here to handle the characters
        }
    }
}