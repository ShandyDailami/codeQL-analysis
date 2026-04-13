import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32483_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<data><city name='New York' population='85,000,000' /><city name='London' population='80,000,000' /></data>";
        parse(xml);
    }

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bCityName = false;
        private boolean bCityPopulation = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("city")) {
                bCityName = true;
                bCityPopulation = true;
            } else if (bCityName && qName.equals("name")) {
                bCityName = false;
            } else if (bCityName && qName.equals("population")) {
                bCityPopulation = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("city") && bCityName && bCityPopulation) {
                System.out.println("City: " + localName + ", Population: " + attributes.getValue("population"));
            }
        }
    }
}