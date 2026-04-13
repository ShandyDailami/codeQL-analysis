import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_11904_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParser {
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private SAXParserFactory saxFactory;
    private SAXParser saxParser;

    public java_11904_XMLParser_A03() {
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        saxFactory = SAXParserFactory.newInstance();
        saxParser = saxFactory.newSAXParser(new Properties());
    }

    public void parse() throws ParserConfigurationException, SAXException {
        InputSource source = new InputSource(new StringReader("<root><data>Some data</data></root>"));
        MyHandler myHandler = new MyHandler();
        saxParser.parse(source, myHandler);
    }

    private class MyHandler extends DefaultHandler {
        private boolean bData;
        private StringBuilder sb;

        public java_11904_XMLParser_A03() {
            bData = false;
            sb = new StringBuilder();
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("data")) {
                bData = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("data")) {
                bData = false;
            } else if (bData) {
                sb.append(qName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bData) {
                sb.append(new String(ch, start, length));
            }
        }

        public void fatalError(String error) throws SAXException {
            throw new SAXException(error);
        }

        public void warning(String msg) {
            System.out.println("Warning: " + msg);
        }
    }
}