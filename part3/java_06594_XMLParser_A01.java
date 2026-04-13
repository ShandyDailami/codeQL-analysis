import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_06594_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("books.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setEntityResolver(new MyEntityResolver());

            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("Number of books: " + handler.getBookCount());
            System.out.println("Books: " + handler.getBooks());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}