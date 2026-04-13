import java.io.*; // Import FileInput/Output streams AND Buffered Reader  
public class java_44856_XMLParser_A03 {   
     public static void main(String args[]) throws Exception{     
         String line;       
          try      
           {            
                File file = new File("example_file");           
                 if (file.exists())             
                   System.out.println("\nParsing XML using SAX: ");              
                      XmlSAXParser saxParser=new  XmlSAXParser();     //Instantiate the parser     
                       while ((line =in.readLine()) != null)    {                  saxParser.parse(         new InputSource(        new StringReader ( line)));          }              in .close() ;                    System.out.println("\nParsing XML using DOM: ");                XmlDOMParser domparser =new 
XmlDOMParser();             // Instantiate the parser     while ((line=in.readLine()) != null) {                  domparser.parse(          new InputSource (         new StringReader    ( line))); }              in .close() ;        System.out.println("\nParsing XML using StAX: ");                   XmlSTAXParser stax parser =new 
XmlSTAXParser();             // Instantiate the parsers     while ((line=in.readLine()) !=  null) {                  stax_parser .parse(      new InputSource (         new StringReader    ( line))); }              in   .close() ;        System.out.println("\nSuccessfully parsed XML documents");               
             else          // File does not exist            Console.WriteLine("File "+file +"  doesn't exists!");                    return;                  };     catch(Exception e){Console.writeline (e.getMessage());};    }   finally{if(!in .isClosed()) in .close();}}