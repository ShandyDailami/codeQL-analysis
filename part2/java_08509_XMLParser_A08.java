import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_08509_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);

            System.out.println("Parsing completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private boolean bName;
    private boolean bAuthor;
    private boolean bGenre;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("book")) {
            bName = true;
            bAuthor = true;
            bGenre = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            bGenre = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        if (qName.equalsIgnoreCase("book")) {
            bName = false;
            bAuthor = false;
            bGenre = false;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("author")) {
            bAuthor = false;
        } else if (qName.equalsIgnoreCase("genre")) {
            bGenre = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAuthor) {
            System.out.println("Author: " + new String(ch, start, length));
        } else if (bGenre) {
            System.out.println("Genre: " + new String(ch, start, length));
        }
    }
}