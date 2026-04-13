import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_37079_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {
        private boolean isItem = false;
        private boolean isTitle = false;
        private boolean isLink = false;
        private String title;
        private String link;
        private List<String> items;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("item")) {
                isItem = true;
            } else if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("link")) {
                isLink = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isItem) {
                String item = new String(ch, start, length);
                items.add(item);
                isItem = false;
            } else if (isTitle) {
                title = new String(ch, start, length);
                isTitle = false;
            } else if (isLink) {
                link = new String(ch, start, length);
                isLink = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("item")) {
                System.out.println("Title: " + title + ", Link: " + link);
                title = null;
                link = null;
            }
        }
    }

    public static void parse(String xml) {
        SAXHelper.setDefaultHandler(new MyHandler());
        SAXHelper.parseXML(xml, true);
    }

    public static void main(String[] args) {
        String xml = "<root><item><title>Title 1</title><link>http://link1.com</link></item><item><title>Title 2</title><link>http://link2.com</link></item></root>";
        parse(xml);
    }
}