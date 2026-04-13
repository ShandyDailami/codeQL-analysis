import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

import java.net.URL;
import java.io.IOException;

public class java_36836_XMLParser_A01 {

    public static void main(String[] args) {
        String urlStr = "http://example.com/books.xml"; // replace with your URL

        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        DefaultHandler handler = new DefaultHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}