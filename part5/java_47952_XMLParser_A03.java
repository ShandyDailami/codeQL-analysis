import java.io.*;  // Import InputStreamReader for decoding purpose, also use PrintWriter to write on file operations   
public class java_47952_XMLParser_A03 {       
       public static void main(String[] args) throws Exception{            
               String inputXML="<person><name>John Doe's Book  </title> <author>  Jane Austen </author ></person>"; // your xml string here          
              try (InputStreamReader reader = new InputStreamReader((new ByteArrayInputStream(inputXML.getBytes())))) {     // convert String to byte stream     
                    int c;         // character read from inputstream         
                       while ((c=reader.read()) != -1)  {       
                             System.out.print((char) c);       }          
                }} catch (FileNotFoundException e){            
                  e.printStackTrace();                  
              }              
    // This will print your XML as a string, but it's not secure if you can access the raw input stream since this could potentially expose sensitive information to attacks like SQL injection or cross-site scripting(XSS). You should always use trusted libraries for these tasks.  If in doubt about security level consider using Spring Framework (Spring JPA is a good option, but still not fully covered by your request)
   }              
}