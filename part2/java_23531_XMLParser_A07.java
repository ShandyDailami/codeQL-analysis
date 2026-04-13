import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23531_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        try {
            parser.parse("src/input.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthor;
        private boolean isTitle;
        private boolean isFirstName;
        private boolean isLastName;
        private boolean isId;
        private boolean isPassword;
        private boolean isAuthFailure;

        @Override
        public void startDocument() throws SAXException {
            isAuthor = isTitle = isFirstName = isLastName = isId = isPassword = isAuthFailure = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("firstName")) {
                isFirstName = true;
            } else if (qName.equalsIgnoreCase("lastName")) {
                isLastName = true;
            } else if (qName.equalsIgnoreCase("id")) {
                isId = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            } else if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
                isAuthor = false;
            } else if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
                isTitle = false;
            } else if (isFirstName) {
                System.out.println("First Name: " + new String(ch, start, length));
                isFirstName = false;
            } else if (isLastName) {
                System.out.println("Last Name: " + new String(ch, start, length));
                isLastName = false;
            } else if (isId) {
                System.out.println("ID: " + new String(ch, start, length));
                isId = false;
            } else if (isPassword) {
                System.out.println("Password: " + new String(ch, start, length));
                isPassword = false;
            } else if (isAuthFailure) {
                System.out.println("AuthFailure: " + new String(ch, start, length));
                isAuthFailure = false;
            }
        }
    }
}