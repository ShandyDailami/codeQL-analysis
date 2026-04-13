import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28393_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // handle the client connection in a separate thread
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_28393_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // read and process the client's request
            // for now, let's just echo back the received data
            while ((clientSocket.getInputStream().read()) != -1) {
                clientSocket.getOutputStream().write(clientSocket.getInputStream().read());
            }
            clientSocket.getOutputStream().close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}