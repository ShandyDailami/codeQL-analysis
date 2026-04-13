import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class java_45479_XMLParser_A03 {
    public static void main(String[] args) throws Exception{ 
        // Create a new instance of the DocumentBuilderFactory  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
        
        try {
            // Use the newly created document builder to parse through xml file     
           DocumentBuilder builder =  factory.newDocumentBuilder();   
         
           // Parse from URL  (Replace 'file:...' with your own XML File location)  
           Document doc = builder.parse( new SourceResource("https://www.w3schools.com/xml/books.html") );    
           
           String bookTag = "book";    // define the tag for `<Book>`     
             XPath xpath =  DocBuilderFactory .newInstance().newXPath();  ///create new instance of an xml path builder  
              PathExpression expr=xpath.compile("//"+ bookTag);     ## create expression to select all books    //book is the root tag for Book in our XML file      
               String str;     
             int i = 0 ;        ///count how many elements we have selected  (We are sure there will be only one element)  
            try {         ---**Protected operations. Use this method to secure your code from injection attacks: **----     // create a protected method for the xml parsing and print operation    public void parseXML(Document doc){        NodeList nodeList =doc .getElementsByTagName (bookTag);      
             System.out.println("Total number of books in XML file : " +nodeList.getLength());      //prints total no book elements   for-each loop to print all the values    str="";     /// create a string variable which will store each value from xml document one by another       
             try {       ---**Protected operations: Use this method to secure your code against SQL Injection attacks. **---  //create protected methods that do not use any user input in the operation    public void printBooks(NodeList nodeList){         for (i = 0; i <nodeList .getLength(); ++i) {
             try{      ----**Protected operations: Use this method to secure your code from SQL Injection attacks. **----   //create protected methods that do not use any user input in the operation    str = nodeList.item(i).getTextContent ();         System .out..println ("Book " + i+1  +":  Title :" + 
             /*str*/) ;     }        try {      ----**Protected operations: Use this method to secure your code from SQL Injection attacks or other injection attack. **----   //create protected methods that do not use any user input in the operation    public void printBooks(String str){         System .out..println (" Book title :" +str); }    
            finally {  ---**Protected operations: Use this method to secure your code from injection attacks or other injections. **----   //create a protected methods that does not use any user input in the operation    public void doSomething(String str){         System .out..println ("Doing something with " +str); }
        }} catch (Exception ex) {  ---**Protected operations: Use this method to secure your code from injection attacks or other injections. **----   //create a protected methods that does not use any user input in the operation    public void doSomething(int i){         System .out..println ("Doing something with " +i); }