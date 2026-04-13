import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_32866_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), new DefaultHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTitle = false;
        boolean bAuthor = false;
        String title = null;
        String author = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTitle = true;
                bAuthor = true;
            } else if (bTitle && qName.equalsIgnoreCase("title")) {
                title = attributes.getValue("name");
            } else if (bAuthor && qName.equalsIgnoreCase("author")) {
                author = attributes.getValue("name");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTitle = false;
                bAuthor = false;
                if (title != null && author != null) {
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                title = new String(ch, start, length);
            } else if (bAuthor) {
                author = new String(ch, start, length);
            }
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}