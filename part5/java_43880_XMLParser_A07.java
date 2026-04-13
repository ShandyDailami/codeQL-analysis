import java.io.*;  // for handling file I/O operation in Java  
public class java_43880_XMLParser_A07 {   
     public static void main(String[] args) throws Exception{      
           FileInputStream fis = new FileInputStream("sampleLegacyStyleFilePath");     
          XmlParser parser=new MyXmlparser();  //creating an object of my XML Parser  
        int content;                         
         while((content=fis.read()) !=  -1){      
            System.out.print((char)content);          
         }    
               fis.close();     
    }}