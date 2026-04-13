import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05629_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your input file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("note");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                DocumentBuilder dbFactory2 = dbFactory.newDocumentBuilder();
                Document doc2 = dbFactory2.newDocument();

                doc2.setDoNamespaces(true);
                doc2.insertBefore(doc.getElementsByTagName("note")
                        .item(temp), doc.getElementsByTagName("note")
                        .item(temp));
                doc2.getDomConfig().setParameter("http://xml.org/sax/features",
                        Boolean.TRUE);

                System.out.println(doc2.getFirstChild().getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}