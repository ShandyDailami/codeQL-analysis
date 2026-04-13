import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultEntityResolver;
import org.xml.sax.ext.LxmlEntityResolver;

import java.io.File;
import java.io.IOException;

public class java_32057_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "input.xml"; // replace with your XML file
        File inputFile = new File(xmlFile);

        try {
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = saxReader.getXMLReader();

            xmlReader.setEntityResolver(new DefaultEntityResolver());

            xmlReader.setValidation(true);
            xmlReader.setDoNamespaces(true);

            SAXParserHandler handler = new SAXParserHandler();
            xmlReader.setContentHandler(handler);

            xmlReader.parse(inputFile);

            System.out.println(handler.getContent());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements ContentHandler {
    private StringBuilder content;

    public java_32057_XMLParser_A03() {
        content = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.append("Start element: ").append(qName).append("\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        content.append("End element: ").append(qName).append("\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append("Characters: ").append(new String(ch, start, length)).append("\n");
    }

    public String getContent() {
        return content.toString();
    }
}