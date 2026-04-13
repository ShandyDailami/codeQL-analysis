import javafx.application.*;

import org.w3c.dom.*;  // Use these import statements as well for parsing and manipulating xml data     (e.g., Document, Element)   from javax .xml.parsers.*;        Importing other utility classes like FileInputSteam etc if required in XML related operations

import java.net.*;    // For URL Connection objects to access web resources  https://stackoverflow.com/questions/21374865/java-how-to-readxmlfilefromurl     importing other utility classes like FileInputSteam etc if required in XML related operations

import java.io.*;    // For InputStream and OutputStream objects to handle file input / output  https://stackoverflow.com/questions/21374865/java-how-to-readxmlfilefromurl     importing other utility classes like FileInputSteam etc if required in XML related operations

   public class java_45882_XMLParser_A07 extends Application {      @Override        public void start(Stage primarystage) throws Exception         URL url = newURL("http://example.com/sample.xml");  // replace with your xml file location or link     DocumentBuilderFactory dbFactory   =DocumentBuilderFactory .newInstance();    Document document    =dbFactory   .newDocumentBuilder().parse (url.openStream());          Element rootElement  =document.getDocumentElement();             System.outprintln ("Root element: " +rootelement);       } public static void main(String[]args) {  Application.launch((Main.class), args );}}