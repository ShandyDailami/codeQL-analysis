import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLLoader.DTDHandler;

import java.io.File;
import java.io.IOException;

public class java_13101_XMLParser_A08 {
    public static void main(String[] args) {
        String url = "yourfile.xml";  // replace with your XML file path
        XMLParserHandler handler = new XMLParserHandler();
        XMLLoader loader = new XMLLoader();

        try {
            loader.setDocumentBuilderFactory(new DocumentBuilderFactory() {
                public DocumentBuilder newInstance() throws ParserConfigurationException {
                    return new DocumentBuilder();
                }
            });
            loader.setDTDHandler(new DTDHandler() {
                public void warning(SAXParseException e) {
                    System.out.println("DTD Warning: " + e.getMessage());
                }

                public void error(SAXParseException e) {
                    System.out.println("DTD Error: " + e.getMessage());
                }

                public void fatalError(SAXParseException e) {
                    System.out.println("DTD Fatal Error: " + e.getMessage());
                }
            });

            Document doc = loader.parse(new File(url));
            doc.getDocumentElement().normalize();
            handler.reset();
            handler.startDocument();
            handler.startElement("root", null, null);
            doc.getDocumentElement().normalize();
            handler.startPrefixMapping("rss", "http://www.w3.org/2005/Atom");
            handler.characters(null, "", "");
            handler.endElement("root", null, null);
            handler.endDocument();
            handler.reset();

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXParseException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}

class XMLParserHandler extends DefaultHandler {
    private boolean bRoot = false;
    private boolean bAuthor = false;
    private String currentElement = null;

    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }

    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    public void endPrefixMapping(String prefix) {
        System.out.println("End Prefix Mapping: " + prefix);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equalsIgnoreCase("author")) {
            bAuthor = true;
            currentElement = localName;
        }
        System.out.println("Start Element: " + localName);
    }

    public void endElement(String uri, String localName, String qName) {
        if (localName.equalsIgnoreCase("author")) {
            bAuthor = false;
            currentElement = null;
        }
        System.out.println("End Element: " + localName);
    }

    public void characters(char[] ch, int start, int length) {
        if (bAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
        }
    }
}