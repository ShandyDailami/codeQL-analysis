import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class java_50290_XMLParser_A01 { 
    public static void main(String[] args) throws Exception{  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
           // parse the xml file into DOM object     
        org.w3c.dom.Document doc=dBuilder.parse( new File("sample.xml") ); 
          printDOM(doc);    return;   }     public static void printDOM(org.w3c.dom.Document dom) {       String tab = "\t";         NodeList nlList =  dom.getElementsByTagName("*");           for (int temp=0 ;temp<nlList.getLength();temp++ ) 
          {             System.out.println(tab+"---------------Element----------- " +dom.getElementsByTagName("*").item(temp).getNodeName());              printNodeDetails((org.w3c.dom.Node) dom . getElementsByTagName ("*" ). item ( temp ));           }
       return;   }}        public static void  printNodeDetails( org.w3c.dom.Node node){    if(node.hasChildNodes()){          for(int i=0 ;i<node.getChildNodes().getLength();++) {             System.out.print("\t" + "\n --- "+"-> Node Name: ");
              printDetails((org.w3c.dom.Node ) node . getChildNodes ()  . item ( i ) );}}          else{           System.out.println(tab+  "->  Data :-"  +node.getNodeValue());} return; }   public static void printDetails( org.w3c.dom.Node n){
    if((n instanceof Element)) {System. out .print("\t" + "\n --- "+"-> Node Name: ");  System.out.println("Element :-"  + ((org.w3c.dom.Element) n).getTagName());           printAttributes( ( org.w3c.dom.Element ) n );}
    else if((n instanceof Text)){System. out .print("\t" + "\n --- "+"-> Node Name: ");  System.out.println("Text :-"  + ((org.w3c.dom.Text) n).getNodeValue()); }   return; }} public static void printAttributes( org.w3c.dom.Element e){    
    if (e . hasAttributes() ) {          for (; !e . getAttributes().equals("") ; ++i ))      System.out.println("\t Attribute :-"  + ((org.w3c.dom.Attribute)   .get attributes ()). item( i ). getNodeName()); } return; }}