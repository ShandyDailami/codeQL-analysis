import java.io.*; // for FileInputStream and InputStreamReader 
public class java_52930_XMLParser_A08 {  
    public static void main(String args[]) throws Exception{    
        readXMLFile("file1");     
        System.out.println();        
      	readXMLFile ("file2" );            
    }          
         
private static XMLParser xmlp; //instance of Xmlparser  
             
public  static void readXMLFile(String fileName) throws Exception {    
            FileInputStream fis= new FileInputStream (fileName+".xml");     
                 InputStreamReader isr =new InputStreamReader (fis,"UTF-8");   
             xmlp=  XML.newParser(); //initialize parser  
              while ((char)isr.read() != -1);     {  char[] innerskipbuffer =  new char[4096];      int readedbytes = isr .read(innerskipbuffer,   2 ,378 ); if (readedbytes==-1){break;}
}              XML.setProperty("http:schemas","java.net;src" + fileName+ ".xml");       // set parser's property   peg  and call parse method to process the content from input stream    xmlp .parse(isr);     System.out.println ("End of "  +fileName ); }     
           catch (Exception e) {          XML.unsetProperty("http:schemas");             //clear parser's property   when exception occurs clear  and print error message       Logger log = null;         if(log==null){LoggerFactory .getLogge log="root";}     System.out.println ("Exception in parsing file "+fileName +":"+  e);
}} //end of main method   }