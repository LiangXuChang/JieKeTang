package com.school.controller;

/**
 * Created by 梁栩菖
 * 2018/10/30 11:26
 */
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocketTest")
public class WebSocketTest {

    public static Session session;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {

        // Print the client message for testing purposes
        System.out.println("Received: " + message);

        // Send the first message to the client
        session.getBasicRemote().sendText("This is the first server message");

        // Send 3 messages to the client every 5 seconds
        int sentMessages = 0;
        while (sentMessages < 3) {
            Thread.sleep(5000);
            session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
            sentMessages++;
        }

        // Send a final message to the client
        session.getBasicRemote().sendText("This is the last server message");
    }


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected");
        this.session = session;
    }

    @OnClose
    public void onClose() {
        System.out.println("Connection closed");
    }

    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void sendObject(JSONObject jsonObject){
        try {
            this.session.getBasicRemote().sendObject(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}