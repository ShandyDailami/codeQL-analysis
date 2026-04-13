import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_10835_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            parseXml("src/main/resources/data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXml(String fileName) throws ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);

        doc.getDocumentElement().normalize();

        NodeList nodes = doc.getElementsByTagName("student");

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);

            String id = node.getAttribute("id");
            String name = node.getAttribute("name");
            String grade = node.getAttribute("grade");

            students.add(new Student(id, name, grade));
        }

        students.stream().forEach(System.out::println);
    }

    static class Student {
        String id, name, grade;

        public java_10835_XMLParser_A08(String id, String name, String grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }
}