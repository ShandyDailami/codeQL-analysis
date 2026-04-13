import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29126_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            DefaultHandler dh = new DefaultHandler() {
                boolean bName = false;
                boolean bAge = false;
                String name = null;
                int age = 0;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equals("person")) {
                        return;
                    } else if (qName.equals("name")) {
                        bName = true;
                    } else if (qName.equals("age")) {
                        bAge = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bName) {
                        name = new String(ch, start, length);
                        bName = false;
                    } else if (bAge) {
                        age = Integer.parseInt(new String(ch, start, length));
                        bAge = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equals("person")) {
                        System.out.println("Name: " + name + ", Age: " + age);
                    }
                }
            };

            sp.parse(XMLParserExample.class.getResourceAsStream("people.xml"), dh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}