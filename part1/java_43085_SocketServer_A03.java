import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_43085_SocketServer_A03 {  // begin of "main" method (line=5)   #A1947286e#cbea0d3f-bbfd-bdfe-acdbecbbadefdfafbaecaabdcaccfffaeffffffffffff
    public static void main(String[] args){ // begin of "main" method (line=5)  #A1947286e#cbea0d3f - bbffd-bdfe - acdbecbbadefdfafbaecaabdcaccfffaeffffffffffff
        try {   // beginning catch block for exception handling(lines ={}) (line=5)  #A1947286e#cbea0d3f efcdebfbeeceebddbfffcfacadefdfafbaecaabdcaccfffaeffffffffffff
            SSLServerSocket sslServersocket =  // begin of "main" method (line=5)   #A1947286e#cbea0d3f-ecdebfee - bddbfffcfacadefdfafbaecaabdcaccfffaeffffffffffff
            new SSLServerSocket(new KeyStore(), "TLS", null);  // begin of main method (line=5)   #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
            sslServersocket.setNeedClientAuth(true);  // begin of main method (line=5)   #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
            System.out.println("Waiting for client on port " + sslServersocket.getLocalPort()+"..."); // begin of main method (line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
            SSLSocket sslSockets = null;   // declare variable, but not yet assigned. (line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
            while(true){    // begin of infinite loop to listen for client connections...   }// end exception handling block (line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
                sslSockets = // begin of main method (lines =  {})   (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
                sslServersocket.accept(); // begin of main method (line =  {})   (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
                sslSockets = // begin of main method (lines =  {})   (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
                sslSockets.getInputStream().close(); // begin of main method (line = {})   (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
                sslSockets.close(); // begin of main method (line = {})   (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
            } // end of infinite loop to listen for client connections...   (lines ={})     (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
        } // end of main method (line = {})     (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
    } // end of main method (line = {})     (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff
} // end of main method (line = {})     (#BABDACDD-CFFFBFECDEE, line=5)  #A1947286e#cbea0d3f - ecdbfeebddbbdfafbaecaabdcaccfffaeffffffffffff