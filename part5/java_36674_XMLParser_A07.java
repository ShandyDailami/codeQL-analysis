import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.xml.sax.SAXException;

public class java_36674_XMLParser_A07 {

    private DefaultHandler defaultHandler;
    private XMLReader xmlReader;

    public java_36674_XMLParser_A07(DefaultHandler defaultHandler, XMLReader xmlReader) {
        this.defaultHandler = defaultHandler;
        this.xmlReader = xmlReader;
    }

    public Document parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return document;
    }
}