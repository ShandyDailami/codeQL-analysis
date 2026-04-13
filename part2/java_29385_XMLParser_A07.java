import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_29385_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

            SAXHandler saxHandler = new SAXHandler();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(inputFile);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bAuthor;
    private boolean bTitle;
    private boolean bLink;
    private boolean bDescription;

    @Override
    public void startDocument() throws SAXException {
        bAuthor = bTitle = bLink = bDescription = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("author")) bAuthor = true;
        else if (qName.equalsIgnoreCase("title")) bTitle = true;
        else if (qName.equalsIgnoreCase("link")) bLink = true;
        else if (qName.equalsIgnoreCase("description")) bDescription = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthor) System.out.println("Author: " + new String(ch, start, length));
        else if (bTitle) System.out.println("Title: " + new String(ch, start, length));
        else if (bLink) System.out.println("Link: " + new String(ch, start, length));
        else if (bDescription) System.out.println("Description: " + new String(ch, start, length));
    }
}