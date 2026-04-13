import javax.xml.parsers.*;  // Importing required parser classes  
public class java_48128_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{         
            String file = "sampleFile.txt";            
             
           // Create a new factory for reading Xml files                   
            DocumentBuilderFactory dbFactory =       DocumentBuilderFactory.newInstance();   
                    
            //Create the parser from the factory    
            XMLReader reader=dbFactory.newSAXParser().getXMLReader();  
            
              Reader filereader = null; 
               try{               
                   System.out.println("Parsing xml using SAX");                 
                      String filename =  "sampleFile";                 // name of the input XML file     
                       reader=dbFactory.newSAXParser().getXMLReader();  
                        HandlerClass handler = new 	HandlerClass();       
                         reader.setContentHandler(handler);      			    		   	     									        	        }catch (Exception e){           System.out.println("Parsing failed");              e.printStackTrace();}                    catch (ParserConfigurationException pce) {                   // Handling Parser Configuration Exception 
                       printExitMessage();                     return;                  };       	    	    case 'A':        		    if(arg[1] !='--file'){           System .outprintln (" Invalid argument");          exit(-2);};            }}}}`});