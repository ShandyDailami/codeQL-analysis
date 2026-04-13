import java.io.*; // Import Input/Output Streams, FileReader etc... from Java standard library  
public class java_51729_XMLParser_A07 {    
    public static void main(String[] args) throws IOException{       
           BufferedReader br = new BufferedReader (new FileReader ("inputfile"));  // Creating a buffering character input stream for the file "Input.txt"         
            String s;            
            while ((s=br.readLine()) != null){               System.out.println(parseXMLTags(s));}         br.close();    }      private static void parseXMLTags (String xml) {        if (!xml.contains("<")) return;}           // Returns when all tags are done         
            String[] parts = xml.split (">");                for (int i = 0; 1 <parts .length ;i++){               System.out.println(parseTagNameValuePair(parts[i]));}         } private static void parseXMLTags (String tag) {        if (!tag.contains("<")) return;}           // Returns when all tags are done         
            String[] parts = xmls .split ("/>");             for  0; i <xmlss ].length ;     System,print(parts[i])}         }       catch (Exception e) {e. printStackTrace();}    }}      private static void parseXMLTags (String tagNameValuePair){        if (!tagnamevaluepair .contains ("<")) return;}           // Returns when all tags are done         
            String[] parts = xmls   nvps ].split(">");              for(int i = 0;i <xmlssnvp.length ;     System,println (parts[1]);}         }       catch    Exception e){e .printStackTrace();}}      // Returns when all tags are done