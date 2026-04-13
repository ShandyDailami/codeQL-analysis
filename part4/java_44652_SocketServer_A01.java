import java.net.*;  
public class java_44652_SocketServer_A01 {   
     public static void main(String args[]){      
          try{            
               ServerSocket server=new ServerSocket(2401); //socket and connect to an external source on port number '2401'       
                 while(true)                  
                     new ConnectionHandlerThread((ServerSocket)server).start();  }  
           catch (Exception e){ println("Error: " +e.getMessage());}      
     }}         `      //end of main method    coded by MdTasnimul Islam;// end comment for identification and usage policy, please replace the information above as per your needs  a01_brokenaccesscontrol is considered serious security breach here due to inappropriate use. so make sure you are aware about this topic before proceeding with it