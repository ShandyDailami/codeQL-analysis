import java.io.*; // Import necessary classes  
public Class Main {   
     public static void main(String args[]) throws IOException{      
          String data;        FileInputStream fstream = new FileInputStream("datafile");           DataInputStream in =new DataInputStream (fstream);            System.out .println("\nReading file: 'datafile' ");  while ((data=in.readLine()) != null){                // Read and display the text  
              if(isValidFileContent((char[]) data)){                     PrintWriter out  = new PrintWriter("output_log", "UTF-8");    System .out ()).println ();     }       }}  catch java.. IOException e {         println ("Error reading file: ",e );}}