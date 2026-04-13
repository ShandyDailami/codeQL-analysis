import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17226_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // create a new thread to handle the client request
                new HandlerThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_17226_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the request here
        // you can do some operations like reading from the client, writing back to the client, etc.
        // for simplicity, we'll just print out the message received
        try {
            String message = "Hello, client!";
            socket.getOutputStream().write(message.getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}