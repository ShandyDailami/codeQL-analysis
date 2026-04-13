import java.awt.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.xml.*;

public class java_38448_XMLParser_A08 {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com/sample.xml");
            XMLReader reader = XML.newReader();
            
            for(;;) {
                int event = reader.event();
                switch(event) {
                case XMLReader.START_DOCUMENT:
                    System.out.println("Start of Document");
                    break;
                case XMLReader.START_ELEMENT:
                    System.out.println("Start of Element: " + reader.getLocalName());
                    break;
                case XMLReader.END_ELEMENT:
                    System.out.println("End of Element: " + reader.getLocalName());
                    break;
                case XMLReader.CHARS:
                    System.out.print(reader.getText());
                    break;
                }
                event = reader.next();
                if(event == XMLReader.END_DOCUMENT)
                    break;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}