import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_00340_XMLParser_A07 {

    public static void main(String[] args) throws IOException {
        // Load the XML file from a zip archive
        ZipInputStream zis = new ZipInputStream(new FileInputStream("path_to_your_zip_file.zip"));
        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {
            if (entry.getName().endsWith(".xml")) {
                XMLReader reader = XMLReaderFactory.createXMLReader();
                InputStream is = zis;
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                reader.setContentHandler(new MyContentHandler(reader1));
                reader.parse(new InputSource(new StringReader(reader1.readLine())));
            }
            zis.closeEntry();
            entry = zis.getNextEntry();
        }
        zis.close();
    }

    static class MyContentHandler implements ContentHandler {

        private BufferedReader reader;

        public java_00340_XMLParser_A07(BufferedReader reader) {
            this.reader = reader;
        }

        public void startDocument() throws SAXException {
            // Do nothing
        }

        public void endDocument() throws SAXException {
            // Do nothing
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do nothing
        }

        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            // Do nothing
        }

        public void processingInstruction(String target, String data) throws SAXException {
            // Do nothing
        }

        public void setDocumentLocator(Locator locator) {
            // Do nothing
        }
    }
}