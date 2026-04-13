import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerWrapper;

import java.io.File;
import java.io.IOException;

public class java_33885_XMLParser_A01 {

    private static class MyHandler extends DefaultHandlerWrapper {

        private DefaultHandlerWrapper handler;

        public java_33885_XMLParser_A01(DefaultHandler handler) {
            this.handler = (DefaultHandlerWrapper) handler;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
            handler.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            handler.endElement(uri, localName, qName);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler(new DefaultHandlerWrapper(new MyHandler(reader))));
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}