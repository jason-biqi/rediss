package com.magic.redis.controller;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/webSocket/**")
@Component
public class WebSocketHandler {

    private static int onlineCount=0;
    private static CopyOnWriteArraySet<WebSocketHandler> webSocketSet=new CopyOnWriteArraySet<>();
    private Session session;
    private String sid="";

    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) {
        System.err.println("begin");
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
        }
        System.err.println("su1111ccess");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        //群发消息
        for (WebSocketHandler item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketHandler.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketHandler.onlineCount--;
    }


}
