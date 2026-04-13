import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10615_XMLParser_A07 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();

    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.xml";
        String outputFile = "src/main/resources/output.txt";

        try {
            File input = new File(inputFile);
            File output = new File(outputFile);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());
            parser.parse(input, new SAXSource(new MyXMLHandler(), true));

            System.out.println("XML parsing completed successfully!");

        } catch (IOException | SAXParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);
        data.append("Start of ").append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.append(" End of ").append(qName);
        System.out.println(data);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }
}