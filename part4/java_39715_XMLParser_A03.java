import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39715_XMLParser_A03 {

    private List<String> values = new ArrayList<>();

    public List<String> parse(String fileName) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = spf.newSAXParser(true, false);
            SAXHandler sh = new SAXHandler();
            saxParser.parse(new FileInputStream(fileName), sh);

            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    class SAXHandler extends DefaultHandler {
        boolean bValue;
        StringBuilder sb;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.schemas.dom.QName qn)
                throws SAXException {
            if (qName.equalsIgnoreCase("value")) {
                bValue = true;
                sb = new StringBuilder();
            }
        }

        @Override
        public java_39715_XMLParser_A03(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("value")) {
                values.add(sb.toString());
                bValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bValue)
                sb.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        List<String> values = parser.parse("input.xml");
        for (String value : values) {
            System.out.println(value);
        }
    }
}