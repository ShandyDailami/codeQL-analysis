import java.awt.List;
import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_26438_XMLParser_A01 {

    public static void main(String[] args) {
        parseXML("data.xml");
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Employees: ");
        NodeList employees = doc.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Node employeeNode = employees.item(i);
            System.out.println("Employee " + (i + 1));

            NodeList employeeDetails = employeeNode.getChildNodes();
            for (int j = 0; j < employeeDetails.getLength(); j++) {
                Node detailNode = employeeDetails.item(j);

                if (detailNode.getNodeType() == Node.ELEMENT_NODE) {
                    switch (detailNode.getNodeName()) {
                        case "name":
                            System.out.println("Name: " + detailNode.getTextContent());
                            break;
                        case "age":
                            System.out.println("Age: " + detailNode.getTextContent());
                            break;
                    }
                }
            }
        }
    }
}