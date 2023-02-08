package udp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.random.RandomGenerator;

public class Server {
    public static void main(String[] args) throws IOException {
        // write your code here
        // OPEN AN UDP SOCKET
        int portNumber = 8081;
        String hostName = "localhost"; // 127.0.0.1
        DatagramSocket socket = new DatagramSocket(portNumber);

        // CREATE A DATAGRAM PACKET AND RECEIVE DATA FROM THE THE SOCKET
        byte[] recvBuffer = new byte[1024];

        while (socket.isBound()) {
            DatagramPacket receivedPacket = new DatagramPacket(recvBuffer, recvBuffer.length);

            System.out.println("Waiting for packet...");
            socket.receive(receivedPacket); // blocking method!

            int port = receivedPacket.getPort();
            InetAddress address = receivedPacket.getAddress();
            String receivedString = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

            if(!(receivedString.equals("hit me"))){
                String response = "UNAVAILABLE OPERATION";
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, address, port);
                socket.send(responsePacket);
                System.out.println("port = " + port);
                System.out.println("Received: " + receivedString);

            }if(receivedString.equals("hit me")){
                String response = FileReader.printRandomQuote();
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, address, port);
                socket.send(responsePacket);
                System.out.println("port = " + port);
                System.out.println("Received: " + receivedString);
                }
            }
        // CLOSE THE SOCKET
        socket.close();

    }
}
