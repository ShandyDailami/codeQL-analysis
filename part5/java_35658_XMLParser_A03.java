import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35658_XMLParser_A03 extends DefaultHandler {

    private String lastTagName;
    private boolean isInTitle;
    private boolean isInLink;
    private boolean isInDescription;
    private boolean isInPubDate;
    private boolean isInEnclosure;
    private StringBuilder content;

    public java_35658_XMLParser_A03() {
        this.lastTagName = "";
        this.isInTitle = false;
        this.isInLink = false;
        this.isInDescription = false;
        this.isInPubDate = false;
        this.isInEnclosure = false;
        this.content = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            System.out.println("Start of Item");
            this.lastTagName = qName;
        }

        if (qName.equalsIgnoreCase("title")) {
            this.isInTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            this.isInLink = true;
        } else if (qName.equalsIgnoreCase("description")) {
            this.isInDescription = true;
        } else if (qName.equalsIgnoreCase("pubDate")) {
            this.isInPubDate = true;
        } else if (qName.equalsIgnoreCase("enclosure")) {
            this.isInEnclosure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            System.out.println("End of Item");
            this.lastTagName = "";
            this.isInTitle = false;
            this.isInLink = false;
            this.isInDescription = false;
            this.isInPubDate = false;
            this.isInEnclosure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.lastTagName != null && this.lastTagName.length() > 0) {
            if (this.isInTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (this.isInLink) {
                System.out.println("Link: " + new String(ch, start, length));
            } else if (this.isInDescription) {
                System.out.println("Description: " + new String(ch, start, length));
            } else if (this.isInPubDate) {
                System.out.println("Publish Date: " + new String(ch, start, length));
            } else if (this.isInEnclosure) {
                System.out.println("Enclosure: " + new String(ch, start, length));
            }
        }
        content.append(new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}