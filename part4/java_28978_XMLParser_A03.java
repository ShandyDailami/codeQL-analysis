import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_28978_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String xmlFile = "example.xml"; // Replace with your XML file
            InputStream fis = new BufferedInputStream(new FileInputStream(xmlFile));
            XMLDecoder decoder = new XMLDecoder(fis);
            
            // Assuming the XML file contains a Person object
            Person person = (Person) decoder.readObject();
            
            // Print the person's name
            System.out.println("Name: " + person.getName());
            
            decoder.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Person {
    private String name;

    public java_28978_XMLParser_A03(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}