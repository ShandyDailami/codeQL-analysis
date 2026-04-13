import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.SAXParseException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.helpers.DefaultHandler;

public class java_27674_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlData = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new StringReader(xmlData)), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String lastTag = "";

        @Override
        public void startElement(String namespaceURI, String localName,
                                 String qualifiedName, Attributes attributes)
                throws SAXException {
            lastTag = qualifiedName;
        }

        @Override
        public void endElement(String namespaceURI, String localName,
                               String qualifiedName) throws SAXException {
            lastTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (lastTag != null && lastTag.equals("body")) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}