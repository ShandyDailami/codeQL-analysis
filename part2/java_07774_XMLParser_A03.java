import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_07774_XMLParser_A03 {

    public void parse(String fileName) {
        File file = new File(fileName);
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            reader.setContentHandler(new MyContentHandler());

            reader.parse(file.toURI().toString());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyEntityResolver extends org.xml.sax.helpers.DefaultEntityResolver {
        @Override
        public InputSource resolveEntity(String url) throws SAXException, IOException {
            if (url.startsWith("http")) {
                return new InputSource(url);
            } else {
                InputSource inputSource = new InputSource(new StringReader(MY_INJECTABLE_STRING));
                return inputSource;
            }
        }
    }

    private static class MyContentHandler extends org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse("src/main/resources/test.xml");
    }
}