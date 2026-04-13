import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;
import org.xml.sax.xmlreader.SAXReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37313_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser(new DummyInputSource(new File("sample.xml")));
            saxParser.setProperty("http://xml.org/sax/properties/external-generalized-element", Boolean.TRUE);
            saxParser.setProperty("http://xml.org/sax/properties/external-dtd-included", Boolean.FALSE);
            saxParser.setProperty("http://xml.org/sax/properties/external-parameterized-entity-references", Boolean.FALSE);
            saxParser.setProperty("http://xml.org/sax/properties/external-dtd-references", Boolean.FALSE);

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            saxParser.parse(new File("sample.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private Map<String, String> map = new HashMap<String, String>();

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            map.put(qName, attributes.getValue("id"));
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Id: " + map.get(qName));
            }
        }

        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }
    }

    static class DummyInputSource implements InputSource {

        private File file;

        public java_37313_XMLParser_A08(File file) {
            this.file = file;
        }

        public InputSource getInstance() {
            return this;
        }

        public Reader getReader() {
            return new FileReader(file);
        }

        public String getEncoding() {
            return "UTF-8";
        }
    }
}