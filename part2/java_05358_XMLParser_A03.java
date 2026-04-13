import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;
import javax.xml.parsers.XMLParser;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.StreamParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class java_05358_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // SAX Parser
            SAXParser saxParser = SAXParser.newInstance();
            SAXReader saxReader = new SAXReader();
            XMLParser xmlParser = saxParser.getXMLStreamReader(saxReader);
            parseXmlUsingSAX(xmlParser);

            // DOM (Document Object Model)
            Document document = getDocument();
            XMLStreamReader xmlStreamReader = document.getXMLStreamReader();
            parseXmlUsingDOM(xmlStreamReader);

        } catch (XMLStreamException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlUsingSAX(XMLParser xmlParser) {
        // SAX Parser implementation
        try {
            xmlParser.setEventHandler(new SAXHandler());
            xmlParser.parse(new InputSource(new StringReader("<root><element>Injected</element></root>")));
        } catch (XMLStreamException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlUsingDOM(XMLStreamReader xmlStreamReader) {
        // DOM implementation
        try {
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamConstants.ELEMENT) {
                    String elementName = xmlStreamReader.getLocalName();
                    if (elementName.equals("element")) {
                        xmlStreamReader.next();
                        String content = xmlStreamReader.getText();
                        System.out.println("Content: " + content);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static Document getDocument() {
        // Load the XML document into a Document object
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new StringReader("<root><element>Injected</element></root>");
        return builder.parse(inputSource);
    }

    // SAX Handler
    private static class SAXHandler implements XMLStreamHandler {
        @Override
        public boolean handleStartElement(XMLStreamReader reader, String elementName, String namespaceURI, String localName, int lineNumber) throws XMLStreamException {
            if (localName.equals("element")) {
                reader.next();
                String content = reader.getText();
                System.out.println("SAX Content: " + content);
            }
            return true;
        }

        @Override
        public boolean handleEndElement(XMLStreamReader reader, String elementName, String namespaceURI, String localName, int lineNumber) throws XMLStreamException {
            return true;
        }

        @Override
        public void startDocument(String namespaceURI, String localName, String version) throws XMLStreamException {
        }

        @Override
        public void endDocument() throws XMLStreamException {
        }

        @Override
        public boolean handleStartPrefixMapping(String prefix, String uri) throws XMLStreamException {
            return true;
        }

        @Override
        public void handleEndPrefixMapping(String prefix, String uri) throws XMLStreamException {
        }
    }
}