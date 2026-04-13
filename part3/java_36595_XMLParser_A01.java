import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36595_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

        File inputFile = new File("input.xml");
        saxParser.parse(inputFile, new MyHandler());
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("student".equals(qName)) {
            String studentData = data.toString();
            // Here you can add the security-sensitive operations, like checking the student data for any broken access control
            System.out.println("Student Data: " + studentData);
        } else {
            data.append(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }
}