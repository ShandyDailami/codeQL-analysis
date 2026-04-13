import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class java_38810_XMLParser_A03 {

    public static void main(String[] args) {

        String xml = "<root><name>John</name><age>30</age></root>";

        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);

            String name = doc.getElementsByTagName("name").item(0).getTextContent();
            String age = doc.getElementsByTagName("age").item(0).getTextContent();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}