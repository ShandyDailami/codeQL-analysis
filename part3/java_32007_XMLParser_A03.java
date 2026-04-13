import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_32007_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";
        File xmlFile = new File(xmlFilePath);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (Stream<String> stream = Files.lines(Paths.get(xmlFile.toPath()))) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(stream.iterator(), myHandler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}