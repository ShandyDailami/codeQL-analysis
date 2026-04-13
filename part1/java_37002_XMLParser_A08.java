import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_37002_XMLParser_A08 extends DefaultHandler {
    // private fields to store data
    private List<String> authorNames = new ArrayList<>();
    private List<Integer> bookIds = new ArrayList<>();
    private List<String> bookTitles = new ArrayList<>();
    private List<String> publicationDates = new ArrayList<>();
    private List<String> genreNames = new ArrayList<>();

    private boolean isAuthor = false;
    private boolean isBook = false;
    private boolean isPublicationDate = false;
    private boolean isGenre = false;

    // the current tag being processed
    private String currentTag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // determine which tag is being processed
        currentTag = qName;

        // initialize the boolean variables
        if(qName.equalsIgnoreCase("author")) {
            isAuthor = true;
        } else if(qName.equalsIgnoreCase("book")) {
            isBook = true;
        } else if(qName.equalsIgnoreCase("publication_date")) {
            isPublicationDate = true;
        } else if(qName.equalsIgnoreCase("genre")) {
            isGenre = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // when an end element is found, reset the boolean variables
        if(qName.equalsIgnoreCase("author")) {
            isAuthor = false;
        } else if(qName.equalsIgnoreCase("book")) {
            isBook = false;
        } else if(qName.equalsIgnoreCase("publication_date")) {
            isPublicationDate = false;
        } else if(qName.equalsIgnoreCase("genre")) {
            isGenre = false;
        }

        // process the data
        if(isAuthor) {
            // add the data to the author list
        } else if(isBook) {
            // add the data to the book list
        } else if(isPublicationDate) {
            // add the data to the publication date list
        } else if(isGenre) {
            // add the data to the genre list
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // if the tag is a data element, add the data to the appropriate list
        if(isAuthor) {
            authorNames.add(new String(ch, start, length));
        } else if(isBook) {
            bookIds.add(Integer.parseInt(new String(ch, start, length)));
        } else if(isPublicationDate) {
            publicationDates.add(new String(ch, start, length));
        } else if(isGenre) {
            genreNames.add(new String(ch, start, length));
        }
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public List<String> getBookTitles() {
        return bookTitles;
    }

    public List<String> getPublicationDates() {
        return publicationDates;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }
}