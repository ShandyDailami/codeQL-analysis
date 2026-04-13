import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16112_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlContent = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget me this weekend!</body>" +
                "</note>";
        parseXmlContent(xmlContent);
    }

    public static void parseXmlContent(String xmlContent) {
        DefaultHandler handler = new DefaultHandler() {
            boolean bto = false;
            boolean bfrom = false;
            boolean bheading = false;
            boolean bbody = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equals("to")) bto = true;
                if (qName.equals("from")) bfrom = true;
                if (qName.equals("heading")) bheading = true;
                if (qName.equals("body")) bbody = true;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("to")) bto = false;
                if (qName.equals("from")) bfrom = false;
                if (qName.equals("heading")) bheading = false;
                if (qName.equals("body")) bbody = false;
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                if (bto) System.out.println("Security alert: Possible data leakage to TO");
                if (bfrom) System.out.println("Security alert: Possible data leakage to FROM");
                if (bheading) System.out.println("Security alert: Possible data leakage in HEADING");
                if (bbody) System.out.println("Security alert: Possible data leakage in BODY");
            }
        };

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xmlContent)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}