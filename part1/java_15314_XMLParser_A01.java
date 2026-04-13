import java.awt.print.Book;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_15314_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            List<String> authorList = new ArrayList<String>();
            List<String> titleList = new ArrayList<String>();

            NodeList authorNodes = doc.getElementsByTagName("author");
            for (int temp = 0; temp < authorNodes.getLength(); temp++) {
                Node authorNode = authorNodes.item(temp);
                authorList.add(authorNode.getTextContent());
            }

            NodeList titleNodes = doc.getElementsByTagName("title");
            for (int temp = 0; temp < titleNodes.getLength(); temp++) {
                Node titleNode = titleNodes.item(temp);
                titleList.add(titleNode.getTextContent());
           
            }

            for (Iterator iter = authorList.iterator(); iter.hasNext();) {
                String author = (String) iter.next();
                for (Iterator iter2 = titleList.iterator(); iter2.hasNext();) {
                    String title = (String) iter2.next();
                    System.out.println("Author: " + author + ", Title: " + title);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}