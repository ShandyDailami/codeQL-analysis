import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_22030_XMLParser_A01 extends DefaultHandler {

    private StringBuilder data;

    public java_22030_XMLParser_A01() {
        data = new StringBuilder();
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler(data));
            parser.parse(new File(fileName));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        System.out.println(data.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.append("<").append(qName);

        for(int i=0; i<attributes.getLength(); i++) {
            data.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }

        data.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        new XMLParser().parse("src/test.xml");
    }
}