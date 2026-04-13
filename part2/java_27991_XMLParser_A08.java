import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSAXParser;
import org.xml.sax.util.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_27991_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLSAXParser parser = (XMLSAXParser) XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new MyContentHandler());
            parser.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {

        private List<String> elementNames = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            elementNames.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            //nothing to do
        }

        public List<String> getElementNames() {
            return elementNames;
        }
    }
}