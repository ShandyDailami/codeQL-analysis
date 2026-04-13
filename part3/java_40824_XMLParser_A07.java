import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class java_40824_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.xml");

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XmlHandler(outputFile));
            parser.parse(Paths.get(inputFile.getPath()), new SAXParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        private File outputFile;
        private StringBuilder content;

        public java_40824_XMLParser_A07(File outputFile) {
            this.outputFile = outputFile;
            this.content = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            content.append("<").append(qName);

            for (int i = 0; i < attributes.getLength(); i++) {
                content.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }

            content.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            content.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            content.append(new String(chars, start, length));
        }

        @Override
        public void endDocument() throws SAXException {
            try {
                Files.write(outputFile.toPath(), (content.toString() + "\u0000").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}