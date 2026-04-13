import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_45559_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        URL url = new URL("http://example.com/books.xml"); // replace with your xml file 
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder builder = factory.newDocumentBuilder();   
         
        Document doc = builder.parse(url.openStream());  
          
        parseBooksXml(doc);     // pass document to the function 
         }             
       private static void parseBooksXml (Document doc) {     
            NodeList booksNode =  doc.getElementsByTagName("book");   
             for (int i=0;i<booksNode.getLength();i++){   // loop through each book node 
                Element element = booksNode.item(i).toElement();    
                 String title  =element.getElementAsText();      
                  System.out.println("Title: "+title);            }             }}`  `