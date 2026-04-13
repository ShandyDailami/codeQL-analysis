import java.io.*;
import java.net.*;

public class java_05558_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = inputStream.readLine();
                System.out.println("Client says: " + message);

                outputStream.writeBytes("Hello Client, You have successfully connected to the server! \n");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}