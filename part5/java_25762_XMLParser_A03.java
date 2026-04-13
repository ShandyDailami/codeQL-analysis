import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25762_XMLParser_A03 {

    public static void main(String[] args) {
        String inputFile = "input.xml";
        String outputFile = "output.txt";

        try {
            File input = new File(inputFile);
            File output = new File(outputFile);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new DefaultHandler());

            parser.parse(input, new XMLHandler(output));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        private FileWriter fw;
        private PrintWriter pw;

        public java_25762_XMLParser_A03(File outputFile) {
            try {
                fw = new FileWriter(outputFile, true);
                pw = new PrintWriter(fw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void startDocument() throws SAXException {
            pw.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            pw.println("End of document");
            pw.close();
            fw.close();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            pw.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            pw.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            pw.println("Characters: " + new String(ch, start, length));
        }
    }
}