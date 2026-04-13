import java.io.*;  // for InputStreamReader, BufferedReader etc...  
class java_44141_XMLParser_A03 {   
public static void main(String[] args) throws Exception{    
        String line;     
         File file = new File("/home/user/.bashrc");      
                if (file.exists()) {               System.out.println("File exists.");            } else  {              throw new IllegalStateException("Unable to find the specified file!");             };     BufferedReader br  =new    BufferedReader(new InputStreamReader   (new FileInputStream("/home/user/.bashrc")) );     
while ((line =br.readLine()) != null)        {          System.out.println("XMLParser: " + line);         }       }}  //End of main method