import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class java_33325_XMLParser_A08 extends DefaultHandler {

    private boolean isTitleElement = false;
    private boolean isLinkElement = false;
    private List<Link> links = new ArrayList<>();
    private Link currentLink = null;

    public class Link {
        public String title = null;
        public String url = null;

        public java_33325_XMLParser_A08(String title, String url) {
            this.title = title;
            this.url = url;
        }

        @Override
        public String toString() {
            return "Link [title=" + title + ", url=" + url + "]";
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("link")) {
            currentLink = new Link("", "");
            isTitleElement = true;
            isLinkElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("link")) {
            links.add(currentLink);
            isLinkElement = false;
        } else if (isLinkElement && isTitleElement) {
            isTitleElement = false;
            currentLink.title = qName;
        } else if (isLinkElement && !isTitleElement) {
            isLinkElement = false;
            currentLink.url = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isLinkElement && isTitleElement) {
            currentLink.title += new String(ch, start, length);
        } else if (isLinkElement && !isTitleElement) {
            currentLink.url += new String(ch, start, length);
        }
    }

    public List<Link> parse(String xml) {
        // Implement SAX parsing here
        throw new UnsupportedOperationException();
    }
}