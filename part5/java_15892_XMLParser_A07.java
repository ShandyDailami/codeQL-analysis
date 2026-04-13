import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15892_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bTitle = false;
        boolean bAuthor = false;
        boolean bGenre = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTitle = true;
                bAuthor = true;
                bGenre = true;
            }
            if (bTitle && qName.equalsIgnoreCase("title")) {
                System.out.print("Title: ");
                System.out.println(attributes.getValue(""));
                bTitle = false;
            }
            if (bAuthor && qName.equalsIgnoreCase("author")) {
                System.out.print("Author: ");
                System.out.println(attributes.getValue(""));
                bAuthor = false;
            }
            if (bGenre && qName.equalsIgnoreCase("genre")) {
                System.out.print("Genre: ");
                System.out.println(attributes.getValue(""));
                bGenre = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                System.out.println();
            }
        }
    }
}