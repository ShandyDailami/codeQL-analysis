import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_25401_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        Socket sock = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
            sslServerSocket.setNeedClientAuthentication(true);

            while (true) {
                sock = sslServerSocket.accept();
                System.out.println("Client Connected!");

                DataOutputStream outToClient = new DataOutputStream(sock.getOutputStream());
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                String clientInput;

                while ((clientInput = inFromClient.readLine()) != null) {
                    System.out.println("Received: " + clientInput);
                    outToClient.write((clientInput + "\n").getBytes());
                }
           
                sock.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
        }
    }
}