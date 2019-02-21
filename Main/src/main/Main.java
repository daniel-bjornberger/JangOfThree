package main;

import httpserver.ServerConnect;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Observable;
import java.util.Observer;

public class Main {

public static void main(String[]args){

    Observer BORT = new Observer() {
        @Override
        public void update(Observable o, Object arg) {

        }
    };
    try {
        ServerSocket serverSocket=new ServerSocket(8082);
        while (true){
            ServerConnect serverConnect=new ServerConnect(BORT,serverSocket);


            Thread thread=new Thread(serverConnect);
            thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            }
    }
}
