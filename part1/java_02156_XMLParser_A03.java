import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_02156_XMLParser_A03 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();
    private String lastTag;
    private boolean inValue = false;
    private String xmlContent = "";

    public String parseXml(String xmlString) {
        try {
            org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = spf.newSAXParser();
            XmlParser handler = new XmlParser();
            saxParser.parse(new InputSource(new StringReader(xmlString)), handler);
        } catch (Exception e) {
            System.out.println("Parsing failed with exception " + e.getMessage());
            return "";
        }
        return xmlContent;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        lastTag = localName;
        tags.add(localName);
        inValue = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equals(lastTag)) {
            inValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (inValue) {
            xmlContent += new String(ch, start, length);
        }
    }
}