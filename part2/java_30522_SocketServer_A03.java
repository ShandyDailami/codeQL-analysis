import java.net.*;

public class java_30522_SocketServer_A03 {
    private int port;

    public java_30522_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // create a new thread to handle the communication with the client
                new HandleClientThread(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while starting the server");
            e.printStackTrace();
       
        }
    }

    public static void main(String[] args) {
        new SocketServer(1234).start();
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_30522_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // read from the client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();
            System.out.println("Received from client: " + message);

            // send a response
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Hello, client!");
            dos.flush();

            socket.close();
        } catch (Exception e) {
            System.out.println("Error occurred while handling the client");
            e.printStackTrace();
        }
    }
}