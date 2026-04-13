import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51903_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{    	
        String xml = "<note>" + "\n\t <to>Tove</to>" +  "\n\t<from>Jani</from>  \n\t<heading>Reminder</heading>  \n\t<body>Don't forget me this weekend!</body></note>";
        	ParserFactory factory = ParserFactory.newInstance();  		    
             DocumentBuilder builder  = factory .newDocumentBuilder();  //Step1: Initialize the documentbuilder         	 			   	   				     					       } catch (ParserConfigurationException e) { System.out.println("Error occurred while parsing configuration");}	catch(IOException ex){System.out.print ("I/O Error Occurred!");}}
        		     Document doc = builder .parse(new InputSource( new StringReader(xml)));   //Step2: Parse the XML file 									     	    } catch (Exception e) { System.out.println("Error occurred while parsing xml document");}      		}       			    public void printElementByTagNameIteratively(Node node,String tagname){
                 NodeList nlist =node .getElementsByTagName((tagname));  //Step3: Retrieve the list of Nodes for that particular Tag     		     System.out.println("Found nodes with tag "+nlist);    }          public void printElementByIdIteratively(Node node,String id){
                 NodeList nlist =node .getElementsByTagName((id)); //Step4: Retrieve the list of Nodes for that particular ID        		     System.out.println("Found nodes with tag "+nlist);    }          public void printElementByIdRecursively(Node node,String id){
                 NodeList nlist =node .getChildNodes();  //Step5: Retrieve the list of Nodes for that particular ID recursive    		      System.out.println("Found nodes with tag "+nlist);    }          public void printElementByTagNameRecursively(Node node,String id){
                 NodeList nlist =node .getChildNodes();  //Step6: Retrieve the list of Nodes for that particular ID recursive    		      System.out.println("Found nodes with tag "+nlist);    }   }}`;//End code snippet, remove comments as required