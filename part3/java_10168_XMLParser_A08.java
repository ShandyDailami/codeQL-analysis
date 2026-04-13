import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_10168_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<bookstore>\n" +
                "<book category='fiction'>\n" +
                "  <title>Harry Potter</title>\n" +
                "  <author>J.K. Rowling</author>\n" +
                "  <price>29.99</price>\n" +
                "</book>\n" +
                "<book category='programming'>\n" +
                "  <title>Introduction to Algorithms</title>\n" +
                "  <author> Thomas H. Cormen</author>\n" +
                "  <price>80.00</price>\n" +
                "</book>\n" +
                "</bookstore>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new DefaultHandler() {

                boolean bTitle = false;
                boolean bAuthor = false;
                boolean bPrice = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("title")) {
                        bTitle = true;
                    } else if (qName.equalsIgnoreCase("author")) {
                        bAuthor = true;
                    } else if (qName.equalsIgnoreCase("price")) {
                        bPrice = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("title")) {
                        bTitle = false;
                    } else if (qName.equalsIgnoreCase("author")) {
                        bAuthor = false;
                    } else if (qName.equalsIgnoreCase("price")) {
                        bPrice = false;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bTitle) {
                        System.out.println("Title: " + new String(ch, start, length));
                    } else if (bAuthor) {
                        System.out.println("Author: " + new String(ch, start, length));
                    } else if (bPrice) {
                        System.out.println("Price: " + new String(ch, start, length));
                    }
                }

            });

            parser.parse(new InputSource(new StringReader(xml)));

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}