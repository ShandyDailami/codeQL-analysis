import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Source;
import javax.xml.transform.domsource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerConfigurationException;

public class java_27295_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        String xpathQuery = "/books/book";

        parseAndTransformXml(xmlFile, xpathQuery);
    }

    private static void parseAndTransformXml(String xmlFile, String xpathQuery) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Source xml = new StreamSource(new java.io.File(xmlFile));
        Document document;

        try {
            document = builder.parse(xml);

            List<String> bookTitles = new ArrayList<>();
            String bookTitle;

            NodeList nodeList = document.selectNodes(xpathQuery);
            for (int i = 0; i < nodeList.getLength(); i++) {
                bookTitle = nodeList.item(i).getChildNodes().item(0).getNodeValue();
                bookTitles.add(bookTitle);
            }

            // Here you can do something with the book titles, such as print them or store them in a database.
            // However, be aware that you are still vulnerable to XML injection attacks.

            for (String title : bookTitles) {
                System.out.println(title);
            }

            // XSLT transformations.
            Source xslt = new StreamSource(new java.io.File("xslt.xsl"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(xslt);
            Result documentOuter = new DOMSource(document);

            transformer.transform(documentOuter, new StreamResult(System.out));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}