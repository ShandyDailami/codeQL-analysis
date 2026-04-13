import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

public class java_14938_XMLParser_A07 {

    private DefaultHandler defaultHandler;

    public java_14938_XMLParser_A07() {
        this.defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String data = new String(ch, start, length);
                System.out.println("Characters: " + data);
            }
        };
    }

    public void parse(String xml) {
        try {
            XMLParser parser = new SAXParser(defaultHandler);
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<root><message>Hello World!</message></root>";
        new CustomSAXParser().parse(xml);
    }
}