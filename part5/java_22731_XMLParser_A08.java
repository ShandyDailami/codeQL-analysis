import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22731_XMLParser_A08 extends DefaultHandler {

    private StringBuilder sb;
    private boolean bTag;
    private String szTag;

    public void startDocument() throws SAXException {
        sb = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bTag = true;
        szTag = qName;
        sb.append("<");
        sb.append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            sb.append(" ");
            sb.append(attributes.getQName(i));
            sb.append("=");
            sb.append('\"');
            sb.append(attributes.getValue(i));
            sb.append('\"');
        }
        sb.append(">");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        sb.append("</");
        sb.append(qName);
        sb.append(">");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            sb.append(new String(ch, start, length));
        }
    }

    public void endDocument() throws SAXException {
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            sp.parse(inputFile, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}