import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05336_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new FileInputStream("sample.xml"));
            doc.getDocumentElement().normalize();

            Iterator<org.w3c.dom.Element> iterator = doc.getElementsByTagName("sampletag").iterator();

            while (iterator.hasNext()) {
                org.w3c.dom.Element element = iterator.next();

                // Print the element's value
                System.out.println("Value of sampletag: " + element.getTextContent());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}