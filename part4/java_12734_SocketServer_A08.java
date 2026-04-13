import java.io.*;
import java.net.*;

public class java_12734_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
       
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Server received your message. Thank you for connecting!");
                }
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}