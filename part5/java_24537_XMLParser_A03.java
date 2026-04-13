import org.dom4j.*;
import org.dom4j.io.*;

import java.io.*;

public class java_24537_XMLParser_A03 {
    public static void parse(String filename) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().build(new File(filename));
            Element root = document.getRootElement();
            walk(root, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void walk(Element element, int indent) {
        String indentation = new String(new char[indent]).replace('\0', ' ');
        System.out.println(indentation + element.getElementName() + " (" + element.getAttribute("id") + ")");
        for (Iterator iterator = element.iterator(); iterator.hasNext(); ) {
            Element child = (Element) iterator.next();
            walk(child, indent + 4);
        }
    }

    public static void main(String[] args) {
        parse("input.xml");
    }
}