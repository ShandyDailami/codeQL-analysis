import java.io.*; // Import File I/O related classes    
    import java.util.*; //Import Default List Interface, Collection Framework methods etc        
          
public class java_45446_XMLParser_A01 {         
      public static void main(String[] args) throws Exception{            
            XMLParser parser= new XMLParser();                        
              try                
                {                     println (parser .parse("sample.xml")); }                      catch                   (.IOException e){  // handle exception here                    console "Error parsing the file");}                            finally   {}    return;          }}`     import java.. javax... org ... com.*;      public class XMLParser{ private static final String TAG_START="<";private       
            int indentationLevel= 0 ;  // for keeping track of nesting level       def parse(fileName):         try              { File xmlFile = new                   File ( file Name);                             BufferedReader br                 =  new   BufferedRea      d    io.FileReader     (" +          sample .xml");             String            line;                     while ((line  =br..readLine()) != null)       
                if(indentationLevel==0 &&         startsWith (           "<?xml version"+ '?' ,               line)){                   indentationLevel ++ ; continue;}                 println ("starting XML parsing..."); for             }         `       catch                     IOException e { console ."Error    reading the file.");}                finally {} return null;}}