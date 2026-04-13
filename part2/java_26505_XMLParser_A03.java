import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_26505_XMLParser_A03 {
    public static void main(String[] args) {
        String urlStr = "http://example.com/books.xml";
        try {
            URL url = new URL(urlStr);
            XMLLoader loader = new XMLLoader();
            XMLParser parser = loader.getParser();

            // Initialize the handler
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);

            // Parse the XML document
            parser.parse(new File(url.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder content;

    @Override
    public void startDocument() throws SAXException {
        content = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        // Do something with content
        System.out.println(content.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.append("<").append(qName);
        appendAttributes(attributes);
        content.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        content.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(new String(ch, start, length));
    }

    private void appendAttributes(Attributes attributes) {
        if (attributes != null) {
            content.append(" ");
            for (int i = 0; i < attributes.getLength(); i++) {
                content.append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
        }
    }
}