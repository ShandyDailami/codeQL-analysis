import java.io.*;
import java.net.*;

public class java_19700_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Client connected!");

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Welcome to the server!");
            out.close();

            System.out.println("Connection closed!");
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}