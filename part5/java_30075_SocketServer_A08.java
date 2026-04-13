import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30075_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            ServerSocket newServerSocket = new ServerSocket(8081);
            while (true) {
                Socket serverSocket = newServerSocket.accept();
                System.out.println("Server connected");

                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            while ((clientSocket.getInputStream().read() != -1)) {
                                clientSocket.getOutputStream().write(serverSocket.getInputStream().read());
                            }
                            clientSocket.close();
                            serverSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }
    }
}