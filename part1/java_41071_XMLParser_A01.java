import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_41071_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            parser.setFeature("http://xml.org/sax/features/namespaces", true);
            parser.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            parser.setFeature("http://xml.org/sax/features/validation", false);
            parser.setFeature("http://xml.org/sax/features/external-general-entity-refs", false);
            parser.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            parser.setFeature("http://xml.org/sax/features/string-interning", false);
            parser.setFeature("http://xml.org/sax/features/end-element-prefixes", false);
            parser.setFeature("http://xml.org/sax/features/rcdata-sections", false);
            parser.setFeature("http://xml.org/sax/features/element-form-default", false);
            parser.setFeature("http://xml.org/sax/features/non-destructive-edit", false);
            parser.setFeature("http://xml.org/sax/features/direct-xml", false);
            parser.setFeature("http://xml.org/sax/features/xml-version", false);
            parser.setFeature("http://xml.org/sax/features/error-handler", false);
            parser.setFeature("http://xml.org/sax/features/lexical-handler", false);
            parser.setFeature("http://xml.org/sax/features/xml-validation", false);
            parser.setFeature("http://xml.org/sax/features/stax-api", true);
            parser.setFeature("http://xml.org/sax/features/method-parameter-name-prefix", false);
            parser.setFeature("http://xml.org/sax/features/class-loader", false);
            parser.setFeature("http://xml.org/sax/features/cdata-sections", false);
            parser.setFeature("http://xml.org/sax/features/non-interactive", false);
            parser.setFeature("http://xml.org/sax/features/external-dtd", false);
            parser.setFeature("http://xml.org/sax/features/implicit-dtd", false);
            parser.setFeature("http://xml.org/sax/features/phased-output", false);
            parser.setFeature("http://xml.org/sax/features/sax2-xml-reader", false);
            parser.setFeature("http://xml.org/sax/features/xml-extensions", false);
            parser.setFeature("http://xml.org/sax/features/xinclude-support", false);
            parser.setFeature("http://xml.org/sax/features/xml-direct-syntax-ugm-pars", false);
            parser.setFeature("http://xml.org/sax/features/xml-direct-syntax-asj-pars", false);
            parser.setFeature("http://xml.org/sax/features/xml-external-pars", false);

            File xmlFile = new File("sample.xml");
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }
}