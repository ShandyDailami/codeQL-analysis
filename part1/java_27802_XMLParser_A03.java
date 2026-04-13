import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicDAO;
import java.io.File;
import java.io.IOException;

public class java_27802_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        BasicDAO dao = new BasicDAO();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            dao.parse(reader, xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}