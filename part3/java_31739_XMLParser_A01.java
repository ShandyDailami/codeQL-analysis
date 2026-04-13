import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_31739_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        try {
            File xml = new File(xmlFile);
            FileReader fileReader = new FileReader(xml);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(fileReader, myHandler);

            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Handler for parsing XML
    public static class MyHandler extends DefaultHandler {

        private boolean bAuthor;
        private boolean bTitle;
        private boolean bContent;
        private StringBuilder author;
        private StringBuilder title;
        private StringBuilder content;

        public java_31739_XMLParser_A01() {
            bAuthor = bTitle = bContent = false;
            author = new StringBuilder();
            title = new StringBuilder();
            content = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("author")) bAuthor = true;
            if (qName.equalsIgnoreCase("title")) bTitle = true;
            if (qName.equalsIgnoreCase("content")) bContent = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAuthor) author.append(new String(ch, start, length));
            if (bTitle) title.append(new String(ch, start, length));
            if (bContent) content.append(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) bAuthor = false;
            if (qName.equalsIgnoreCase("title")) bTitle = false;
            if (qName.equalsIgnoreCase("content")) bContent = false;
        }

        public void printResults() {
            System.out.println("Author: " + author.toString());
            System.out.println("Title: " + title.toString());
            System.out.println("Content: " + content.toString());
        }
    }
}