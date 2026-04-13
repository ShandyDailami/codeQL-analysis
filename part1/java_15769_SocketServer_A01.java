import java.io.*;
import java.net.*;
import java.util.*;

public class java_15769_SocketServer_A01 {

    private static ArrayList<Socket> clientList;
    private static ServerSocket serverSocket;
    private static boolean stopped;

    public static void main(String[] args) throws IOException {
        clientList = new ArrayList<>();
        serverSocket = new ServerSocket(3333);
        System.out.println("Server started...");

        while(!stopped){
            Socket clientSocket = serverSocket.accept();
            clientList.add(clientSocket);

            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }

    private static class SocketHandler implements Runnable{

        private Socket clientSocket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_15769_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;

            try{
                dis = new DataInputStream(clientSocket.getInputStream());
                dos = new DataOutputStream(clientSocket.getOutputStream());
            }catch(IOException e){
                clientSocket.close();
                e.printStackTrace();
            }
        }

        @Override
        public void run(){
            String message;

            try{
                while((message = dis.readUTF()) != null){
                    System.out.println("Received: " + message);

                    for(Socket sock : clientList){
                        dos.writeUTF(message);
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            closeConnection();
        }

        private void closeConnection(){
            try{
                clientSocket.close();
                clientList.remove(clientSocket);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}