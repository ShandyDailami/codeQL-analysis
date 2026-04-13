import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_28099_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Document innerDoc = nodeList.get(i).getDocumentElement();

                System.out.println("Book " + (i + 1));
                System.out.println("Title: " + innerDoc.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Author: " + innerDoc.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Year: " + innerDoc.getElementsByTagName("year").item(0).getTextContent());
                System.out.println("----------------------");
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}