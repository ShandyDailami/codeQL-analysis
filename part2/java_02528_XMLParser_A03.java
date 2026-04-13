import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DOMSource;

public class java_02528_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileReader fileReader = new FileReader(inputFile);
            
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            
            xmlReader.setContentHandler(new ContentHandler());
            
            Document document = xmlReader.getDocument();
            
            xmlReader.parse(new Source(new FileReader(inputFile)));
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler implements javax.xml.parsers.ContentHandler {

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
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

    }

    static class Source implements javax.xml.transform.Source {

        private FileReader reader;

        public java_02528_XMLParser_A03(FileReader reader) {
            this.reader = reader;
        }

        @Override
        public Document getDocument() {
            return null;
        }

        @Override
        public InputSource getInputSource() {
            return new InputSource(reader);
        }

    }

}