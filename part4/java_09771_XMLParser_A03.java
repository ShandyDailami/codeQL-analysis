import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_09771_XMLParser_A03 {
    public static void main(String[] args) {
        String inputFile = "input.xml";
        String outputFile = "output.txt";
        parseXML(inputFile, outputFile);
    }

    public static void parseXML(String inputFile, String outputFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(inputFile)));

            XMLHandler handler = new XMLHandler();
            parser.parse(new InputSource(new File(inputFile)), handler);

            // Write output to file
            FileWriter writer = new FileWriter(outputFile);
            writer.write(handler.getOutput());
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        private StringBuilder output;
        private boolean inElement;

        public java_09771_XMLParser_A03() {
            output = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            inElement = true;
            output.append("<");
            output.append(qName);

            if (attributes.getLength() > 0) {
                output.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    output.append(attributes.getQName(i) + "=" + '\"' + attributes.getValue(i) + '\"' + " ");
                }
            }

            output.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            inElement = false;
            output.append("</");
            output.append(qName);
            output.append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inElement) {
                output.append(new String(ch, start, length));
            }
        }

        public String getOutput() {
            return output.toString();
        }
    }
}