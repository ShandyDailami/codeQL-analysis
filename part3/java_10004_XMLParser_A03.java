import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10004_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<data><student id='1'><name>John Doe</name><grade>A</grade></student><student id='2'><name>Jane Doe</name><grade>B</grade></student></data>";
        parseXml(xml);
    }

    private static void parseXml(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XmlHandler());
            saxParser.parse(new InputSource(new StringReader(xml)), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        boolean bName = false;
        boolean bGrade = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bName = true;
                bGrade = true;
            }

            if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name found: " + attributes.getValue("id"));
                bName = false;
            } else if (bGrade && qName.equalsIgnoreCase("grade")) {
                System.out.println("Grade found: " + attributes.getValue("id"));
                bGrade = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bName = false;
                bGrade = false;
            }
        }
    }
}