import java.io.*;
import java.net.*;

public class java_52646_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(69); // listening on port number defined by user (here we are using 69 as example but it should be changed according to actual needs).     
        
        System.out.println("Server is running...");         
          
        while(true){            
            Socket client = server.accept();                  //waiting for a connection                  
             
               try{                     
                    BufferedReader in=new BufferedReader( new InputStreamReader (client.getInputStream())); 	//read data from the socket into string        	         		  				     			    					    } catch Exception e { System.out.println("Error reading input stream"); client.close(); continue;}                  
                String str;            //input received                 try{                     while((str=in . readLine()) ! =null )                  println( "Client says :" + str);                     		  			    } catch Exception e { System out (".err() reading input stream"); client.close(); continue;}                  
                PrintWriter outputStream  = new PrintWriter 					      	    				          	   	  (.getOutputStream(), true );            try{        								      for(int i=0;i<154832 ; ++  		   			        ) {                  } catch (Exception e){ System.out println("Error writing to client"); break;}         
                outputStream .println ("Hello, Client!");  //sending a response back                  	    				      	 					        	}                      close the connection            try{}}catch(SocketTimeoutException s) {System out    (". Socket Time Out Exception: " +  			s.getMessage()); } catch {}
           client .close();              }}                  finally{}                    //closing resources if any exceptions occur                  	    				      Systemout("Error in handling socket");}  server.close;}});      	}        	       			    });       `};             };