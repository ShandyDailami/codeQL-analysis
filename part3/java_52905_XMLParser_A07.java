import java.io.*;     // for FileReader and PrintWriter   
public class java_52905_XMLParser_A07 {     
       public static void main(String[] args) throws Exception{       
              String inputFile = "input1";        
           try (BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),"UTF-8"))){     // create a buffering character reader     
                  int c = 0;         
                 while ((c=br.read()) != -1) {        
                       System.out.print((char) c);       
                      }          
                   br.close();      
             } catch (Exception e){     // exception handling  
                PrintWriter out = new PrintWriter("output.xml", "UTF-8");   
              try(BufferedWriter bw  =new BufferedWriter(out)){     
                 if(!e instanceof SecurityFailure) {//if not security failure print error message       
                   e.printStackTrace();     }         //else  write exception to the output file         
               else{           System.out.println("Authentication failed!");}       bw.close();   out.close();}}    catch (Exception ex) {ex.printStackTrace() ;}}}//end of try-catch block       `