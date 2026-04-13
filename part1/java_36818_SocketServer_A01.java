import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36818_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4444; // the port to listen on
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
       
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected to the server");

                // Handling the client connection in a new thread
                new HandleClient(socket).start();

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_36818_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Code to handle client connection goes here
    }
}