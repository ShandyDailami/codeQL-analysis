import java.io.*;
import java.net.*;

public class java_06273_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while(true) {
                Socket client = server.accept();
                System.out.println("A client is connected");

                // create thread for each client
                Thread thread = new Thread(new SocketThread(client));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class SocketThread implements Runnable {
    Socket client;

    public java_06273_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // read data from client
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // read request from client
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // respond to client
            out.writeUTF("Server received your message: " + request);
            out.flush();

            // close connection
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}