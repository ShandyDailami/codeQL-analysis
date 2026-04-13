import java.io.*;
import java.net.*;

public class java_12348_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);

        System.out.println("Waiting for client on port: " + serverSocket.getLocalPort() + "...");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();

            if (clientMessage.equals("AUTH")) {
                String user = dataInputStream.readUTF();
                String password = dataInputStream.readUTF();

                if (user.equals("test") && password.equals("test")) {
                    dataOutputStream.writeUTF("AUTH_SUCCESS");
                } else {
                    dataOutputStream.writeUTF("AUTH_FAILURE");
               
                }
            } else {
                dataOutputStream.writeUTF("NO_AUTH");
            }

            dataOutputStream.close();
            clientSocket.close();
        }
    }
}