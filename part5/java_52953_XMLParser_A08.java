import java.io.*;   // Import of Java I/O packages 

import javax.xml.parsers.*;  // XML parser library for handling xml files   

public class java_52953_XMLParser_A08 {    

 public static void main(String[] args) throws ParserConfigurationException, IOException{      

      File inputFile = new File("inputfile");  

        DocumentBuilderFactory dbFactory = 

            DocumentBuilderFactory.newInstance();  //Create factory for XML documents   

         DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();    

          //Read the input file into a DOM object, here we call this method of DBUilder class   and pass our filename as parameter to it     

        Document doc =dBuilder.parse(inputFile); 

       System.out.println("XML File Read Successfully");    }    

}