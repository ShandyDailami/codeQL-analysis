import java.util.*;  
class java_52517_XMLParser_A03 {    
    static class XMLElement{     
        String tag;         
        Map<String, List<XMLElement>> childs = new HashMap<>();        
        public XMLElement(String s){this.tag=new String(s);}  //constructor to create a node with the given string as its name    };   }      class Main{     static void parseXML (ArrayList<Object> parent, Object obj) {       if (!((obj instanceof XMLParser$XMLElement))) return;       
         XMLElement e = ((Main.XMLElement)((List < ? > ) Obj).get 0();          // get first child of the current node      Main .parseXML (e, ...);     }   public static void main(){    new ArrayList<Object>().add("a")