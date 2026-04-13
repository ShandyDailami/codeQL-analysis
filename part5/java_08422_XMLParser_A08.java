import java.awt.List;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08422_XMLParser_A08 {

    public static void main(String[] args) {

        File inputFile = new File("input.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);

        doc.getDocumentElement().normalize();

        List children = doc.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            System.out.println(children.item(i));
        }
    }
}