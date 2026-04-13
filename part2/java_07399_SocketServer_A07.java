import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07399_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a server socket and a new server thread
            ServerSocket serverSocket = new ServerSocket(12345);
            new EchoServerThread(serverSocket).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // The server thread
    static class EchoServerThread extends Thread {
        private ServerSocket serverSocket;

        public java_07399_SocketServer_A07(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // Accept a new client connection
                    Socket clientSocket = serverSocket.accept();

                    // Get the output stream from the socket
                    OutputStream outToClient = clientSocket.getOutputStream();

                    // Echo back to the client
                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String clientMessage;
                    while ((clientMessage = inFromClient.readLine()) != null) {
                        outToClient.println(clientMessage);
                        outToClient.flush();
                    }

                    // Close the socket
                    clientSocket.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}