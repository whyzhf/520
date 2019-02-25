package com.zhf.why.serviceImpl;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhf
 * @ServerEndpoint: 注解的值将被用于监听用户连接的终端访问URL地址,
 *                  客户端可以通过这个URL来连接到WebSocket服务器端
 *                  跟Controller层的url一样
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {

    //静态变量,用来记录当前在线连接数.应该把它设计成线程安全的
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
    //若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();

    //与某个客户端的连接会话,需要通过它来给客户端发送数据
    private Session session;


    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。
     *                 session为与某个客户端的连接会话，
     *                 需要通过它来给客户端发送数据
     */
    @OnOpen
    public  void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        addOnLineCount();
        System.out.println("有新连接加入!当前在线人数为"+getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     * 客户端发送过来的消息
     *
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("来自客户端的消息: "+message);
        //群发消息
        for (WebSocketTest item: webSocketSet){
            try {
                item.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
                continue;
            }
        }
    }

    /*
     * 关闭连接调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭!当前在线人数为"+getOnlineCount());
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }




    /**
     *
     *111111111111111111111111111111111111111111
     */

    public static synchronized  void addOnLineCount(){
        WebSocketTest.onlineCount++;
    }

    public  static synchronized  int getOnlineCount(){
        return  onlineCount;
    }

    public void sendMessage(String message) throws IOException {

        this.session.getBasicRemote().sendText(message);
    }

    public static  synchronized  void subOnlineCount(){
        WebSocketTest.onlineCount--;
    }
}
