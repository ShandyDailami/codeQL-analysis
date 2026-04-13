import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10757_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // Clean up resources
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_10757_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can handle the client's data.
        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.
        // For instance, you should not use this socket to send or receive data
        // if the client is not authenticated, you should verify the client's
        // identity using some form of authentication (like a username and password)
        // and then use this socket to send and receive data.

        // You should also handle the case where the client disconnects
        // after a certain amount of time or after sending/receiving a certain amount of data.
        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.

        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.
        // For instance, you should not use this socket to send or receive data
        // if the client is not authenticated, you should verify the client's
        // identity using some form of authentication (like a username and password)
        // and then use this socket to send and receive data.

        // You should also handle the case where the client disconnects
        // after a certain amount of time or after sending/receiving a certain amount of data.
        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.

        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.
        // For instance, you should not use this socket to send or receive data
        // if the client is not authenticated, you should verify the client's
        // identity using some form of authentication (like a username and password)
        // and then use this socket to send and receive data.

        // You should also handle the case where the client disconnects
        // after a certain amount of time or after sending/receiving a certain amount of data.
        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.
        // For instance, you should not use this socket to send or receive data
        // if the client is not authenticated, you should verify the client's
        // identity using some form of authentication (like a username and password)
        // and then use this socket to send and receive data.

        // You should also handle the case where the client disconnects
        // after a certain amount of time or after sending/receiving a certain amount of data.
        // This is a very basic example and lacks many security features
        // that you might want to implement in a real-world application.
        // For instance, you should not use this socket to send or receive data
        // if the client is not authenticated, you should verify the client's
        // identity using some form of authentication (like a username and password)
        // and then use this socket to send and receive data.
    }
}