import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_41836_XMLParser_A03 extends DefaultHandler {

    private boolean bName;
    private boolean bAuthor;
    private String strName;
    private String strAuthor;

    public java_41836_XMLParser_A03() {
        bName = bAuthor = true;
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bName = bAuthor = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
            strName = "";
        } else if (bAuthor && qName.equalsIgnoreCase("author")) {
            bAuthor = false;
            strAuthor = "";
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Book Title : " + strName);
            System.out.println("Book Author : " + strAuthor);
            System.out.println("End of book");
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName)
            strName += new String(ch, start, length);
        else if (bAuthor)
            strAuthor += new String(ch, start, length);
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser());
            reader.parse(new File("books.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}