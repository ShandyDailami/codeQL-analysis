import java.io.*;
import java.net.*;

public class java_03237_SocketServer_A08 {
    private ServerSocket serverSocket;

    public java_03237_SocketServer_A08(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            OutputStream writer = new OutputStream(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                String responseMessage = "Hello, client!";
                writer.write(responseMessage.getBytes());
                writer.newLine();
                writer.flush();
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(8080);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}