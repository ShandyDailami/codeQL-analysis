import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;
import org.xml.sax.helpers.XMLReaderFactoryImpl;

import java.io.File;
import java.io.IOException;

public class java_19115_XMLParser_A03 {
    private DefaultHandler handler;
    private XMLReader reader;

    public java_19115_XMLParser_A03() throws IOException, SAXException {
        this.handler = new DefaultHandler();
        XMLReaderFactory factory = XMLReaderFactoryImpl.createXMLReader();
        this.reader = factory.createXMLReader(new File("input.xml"));
        this.reader.setContentHandler(this.handler);
    }

    public void parse() throws IOException, SAXException {
        this.reader.parse(new File("input.xml"));
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new XMLParser();
        parser.parse();
    }
}