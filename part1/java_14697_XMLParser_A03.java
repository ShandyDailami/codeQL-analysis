import java.beans.XMLEncoder;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14697_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        String fileUrl = "http://example.com/books.xml"; // replace with your URL
        parseXML(fileUrl);
    }

    private static void parseXML(String fileUrl) throws Exception {
        URL url = new URL(fileUrl);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(url.openConnection().getInputStream());

        MyHandler myHandler = new MyHandler();
        saxParser.parse(url.openConnection().getInputStream(), myHandler);

        List<String> names = myHandler.getNames();
        for (String name : names) {
            System.out.println(name);
        }

        XMLEncoder encoder = new XMLEncoder(new PrintWriter("output.xml"));
        encoder.writeObject(names);
        encoder.close();
    }

    private static class MyHandler extends DefaultHandler {
        private List<String> names = null;
        private StringBuilder tempValue = null;

        public List<String> getNames() {
            return names;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tempValue = new StringBuilder();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            tempValue.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("name".equals(qName)) {
                names.add(tempValue.toString());
            }
        }
    }
}