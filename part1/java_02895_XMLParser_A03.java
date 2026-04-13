import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_02895_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "books.xml"; // Replace with the path to your XML file
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        SAXHelper helper = new SAXHelper();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File(xmlFilePath));
            parseXmlDocument(helper, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void parseXmlDocument(SAXHelper helper, InputStream inputStream) {
        helper.setContentHandler(new ContentHandler());
        helper.parse(inputStream);
    }

    private static class ContentHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isAuthor = false;
        private boolean isPublicationDate = false;
        private String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("publicationdate")) {
                isPublicationDate = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                currentValue = new String(ch, start, length);
                isTitle = false;
            } else if (isAuthor) {
                currentValue += " " + new String(ch, start, length);
                isAuthor = false;
            } else if (isPublicationDate) {
                currentValue += " " + new String(ch, start, length);
                isPublicationDate = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                List<String> books = helper.getBooks();
                books.add(currentValue);
                currentValue = null;
            }
        }
    }
}