import java.io.*;
import javax.xml.parsers.*;
public class java_45851_XMLParser_A03 {  
    public static void main(String args[]) throws Exception{    
        File inputFile = new File("inputfile"); //Replace "A01" with your file'name and path, or change the string to another location     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
         
         try {   
            System.out.println(dbFactory);  //This will print: org.xml.sax.helpers.DefaultHandler
             } catch (Exception e) {    
                e.printStackTrace();     
              }      
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
            try{  
               System.out.println(dBuilder);  //This will print: org.xml.sax.helpers.DefaultHandler, SAX Builder has been compiled against DOM Source/Writer and RSS I/O sources at java:/org/w3c/dom PARSERS_MERGE
            } catch (Exception e) {    
                e.printStackTrace();     
             }   
           Document doc = dBuilder.parse(inputFile);   //Here the file needs to be present in your project's directory, or you can replace "A01" with another location         
            try{  System.out.println("Document parsing successful");} catch (Exception e) {    
                e.printStackTrace();      }   
        XPathFactory xpathfactory = new XPathFactory();   //For creating a Path for xml document        
             DocumentBuilder dbbuilder=xpathfactory .newDocumentBuilder(); 
              try{ System.out.println(dbbuilder);//This will print: org.xml.sax.helpers (DefaultHandler, SAX Builder has been compiled against DOM Source/Writer and RSS I/O sources at java:/org/w3c/dom PARSERS_MERGE
            } catch (Exception e){  //try-catch block to handle exceptions if any arises  
                System.out.println(e);   
             }           try{     dbbuilder = xpathfactory .newDocumentBuilder();      Document newDoc=dbbuilder..parse("A02_MaliciousData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises  
                System.out.println(e);    }             try{     dbbuilder = xpathfactory .newDocumentBuilder();      Document newDoc=dbbuilder..parse("A03_InjectionData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises  
                System.out.println(e);    }        try{     dbbuilder = xpathfactory .newDocumentBuilder();      Document newDoc=dbbuilder..parse("A04_XMLParsing");} catch (Exception e) {  //try-catch block to handle exceptions if any arises  
                System.out.println(e);    }            try{     dbbuilder = xpathfactory .newDocumentBuilder();      Document newDoc=dbbuilder..parse("A05_SecurityData");} catch (Exception e){//this is where it will print: orgxmlparser/orgxmldataprocessor
                System.out.println(e);    }  //It's important to note that, the above examples are very basic and might not work in your scenario due xml injection attacks or other complex cases      };   try{     dbbuilder = xpathfactory .newDocumentBuilder(); newDoc=dbbuilder..parse("A06_XPathData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }              print("\n\t Program completed successfully.");     };      try{   dbwriter = xpathfactory .newWriter(); newDoc=dbbuilder..parse("A02_MaliciousData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }            print("\n\t Program completed successfully.");      };   try{     dbwriter = xpathfactory .newWriter(); newDoc=dbbuilder..parse("A03_InjectionData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }          print("\n\t Program completed successfully.");       };   try{     dbwriter = xpathfactory .newWriter(); newDoc=dbbuilder..parse("A04_XMLParsing");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }            print("\n\t Program completed successfully.");       };   try{     dbwriter = xpathfactory .newWriter(); newDoc=dbbuilder..parse("A05_SecurityData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }          print("\n\t Program completed successfully.");      };   try{     dbwriter = xpathfactory .newWriter(); newDoc=dbbuilder..parse("A06_XPathData");} catch (Exception e) {  //try-catch block to handle exceptions if any arises   
                System.out.println(e); }              print("\n\t Program completed successfully.");      };   });      
            }}    `