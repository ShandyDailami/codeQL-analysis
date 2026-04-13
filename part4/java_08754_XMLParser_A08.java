import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_08754_XMLParser_A08 {

    public static void main(String[] args) {
        // Instantiate SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Obtain an SAXParser
        SAXParser sp = spf.newSAXParser();

        // Use SAX to parse XML
        MyHandler mh = new MyHandler();
        sp.parse("src/main/resources/test.xml", mh);
    }
}

class MyHandler extends DefaultHandler {

    private boolean bName;
    private boolean bAuthor;
    private boolean bPublisher;
    private boolean bYear;
    private boolean bPrice;
    private boolean bGenre;

    private String name;
    private String author;
    private String publisher;
    private int year;
    private double price;
    private String genre;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("book")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
            return;
        }

        if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
            return;
        }

        if (qName.equalsIgnoreCase("publisher")) {
            bPublisher = true;
            return;
        }

        if (qName.equalsIgnoreCase("year")) {
            bYear = true;
            return;
        }

        if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
            return;
        }

        if (qName.equalsIgnoreCase("genre")) {
            bGenre = true;
            return;
        }

        // Store the name of the current element
        if (bName) {
            name = attributes.getValue("name");
            bName = false;
        }

        // Store the author of the current element
        if (bAuthor) {
            author = attributes.getValue("author");
            bAuthor = false;
        }

        // Store the publisher of the current element
        if (bPublisher) {
            publisher = attributes.getValue("publisher");
            bPublisher = false;
        }

        // Store the year of the current element
        if (bYear) {
            year = Integer.parseInt(attributes.getValue("year"));
            bYear = false;
        }

        // Store the price of the current element
        if (bPrice) {
            price = Double.parseDouble(attributes.getValue("price"));
            bPrice = false;
        }

        // Store the genre of the current element
        if (bGenre) {
            genre = attributes.getValue("genre");
            bGenre = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println("Book: " + name);
            System.out.println("Author: " + author);
            System.out.println("Publisher: " + publisher);
            System.out.println("Year: " + year);
            System.out.println("Price: " + price);
            System.out.println("Genre: " + genre);
            System.out.println();
            return;
        }
    }
}