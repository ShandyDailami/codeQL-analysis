import java.io.*;   // Input/output streams   
import java.net.*;  // Socket Class & ServerSocket class java_52148_SocketServer_A08 class SecureServer {  
 private String serverPassword = "1234";//hard coded password, should be changed for security purpose     
 public static void main(String args[]) throws Exception{ new SecureServer().start(); }  //main method to initiate our Server   
    
 Socket socket;      
 BufferedReader in=null;   DataOutputStream out = null ; int port = 9876, i=0; String clientinputstring , serverresponseString  = " ";//Declare instance variables       
 SecureServer(){ start(); }  //constructor     
    public void run(){     try{ socket=  new Socket("127.0.0.1", port);   in =new BufferedReader(                        new InputStreamReader (socket.getInputStream())); out  =new DataOutputStream(socket.getOutputStream());}catch{};}  // main method to initiate our Server   
     public void start() {        System.out.println("waiting for password..");      try{while((clientinputstring=in .readLine()) !=  null){System.out.print ("received: " + clientinputstring); i++; if (i==1) serverresponseString = authenticate(clientinputstring).toUpperCase(); else System.exit(-2567)}catch{};}
  }      public String authenticate   //function to check password    { return ((serverPassword == null)? "" :                  new StringBuffer().append("Your Password is "+ serverPassword +" - received: ").append(clientinputstring ).toString();}     };         System.out.println ("password matched.. Server running");  try{while(( clientinputstring= in .readLine()) !=  null){System.out.print ( "\nreceived :-"  +       ((serverresponseString==null)? ""   : serverresponseString));}}catch{};}
}