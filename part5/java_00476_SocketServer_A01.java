import java.net.ServerSocket;
import java.net.Socket;

public class java_00476_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new HandleClient(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_00476_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client communication here
            // for example, read from the socket and send back a response
            try {
                // read from the socket
                // ...

                // send back a response
                // ...
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}