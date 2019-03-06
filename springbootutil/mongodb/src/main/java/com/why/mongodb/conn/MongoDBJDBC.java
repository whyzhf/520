package com.why.mongodb.conn;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
/**
 * @Auther: why
 * @Data:2019/3/6
 * @Deacription:
 */
public class MongoDBJDBC {


    public static void main( String args[] ){
        //创建数据库（集合）
         //  createCollection(conn1(),"why");
        //获取数据库（集合）
        MongoCollection<Document> collection= getCollection(conn1(),"why");
        //插入文档
//         Document document = new Document("title", "MongoDB").
//                                 append("description", "database").
//                                 append("likes", 100).
//                                 append("by", "Fly");
//        List<Document> documents = new ArrayList<Document>();
//        documents.add(document);
//        insertMany(collection,documents);
        //检索所有文档
//        FindIterable<Document> findIterable=find(collection);
//        MongoCursor<Document> mongoCursor = findIterable.iterator();
//        while(mongoCursor.hasNext()){
//            System.out.println(mongoCursor.next());
//        }
        //更新文档
        updateMany(collection);
       // flag=0:删除第一个； 否则删除所有
        remove(collection,0);
    }
    /**
       * 功能描述
       * @author why
       * @date 2019/3/6
       * @param
       * @return void
       * @description 无用户名密码
     */
    public static MongoDatabase conn1 ( ){
        try{//连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
            return mongoDatabase;
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }
    /**
     * 功能描述
     * @author why
     * @date 2019/3/6
     * @param
     * @return void
     * @description 用户名 数据库名称 密码
     */
    public static MongoDatabase conn2 (String username,String password,String databaseName  ){
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential(username, databaseName, password.toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
            System.out.println("Connect to database successfully");
            return mongoDatabase;
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }
    /**
       * 创建集合
       * @author why
       * @date 2019/3/6
       * @param mongoDatabase 数据库连接
       * @param dbname  集合名称
       * @return void
       * @description
     */
    public static void createCollection ( MongoDatabase mongoDatabase,String dbname){
        try{
             mongoDatabase.createCollection(dbname);
             System.out.println("集合创建成功");
         }catch(Exception e){
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    /**
     * 获取集合
     * @author why
     * @date 2019/3/6
     * @param mongoDatabase 数据库连接
     * @param dbname  集合名称
     * @return void
     * @description
     */
    public static MongoCollection<Document> getCollection ( MongoDatabase mongoDatabase,String dbname){
        try{
            MongoCollection<Document> collection = mongoDatabase.getCollection(dbname);
            System.out.println("集合 "+dbname+" 选择成功");
            return collection;
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }

    /**
     * 插入文档
     * @author why
     * @date 2019/3/6
     * @param collection 获取集合
     * @param documents 插入的数据集合
     * @return void
     * @description
     */
    public static void insertMany ( MongoCollection<Document> collection,List<Document> documents){
        try{
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 检索所有文档
     * @author why
     * @date 2019/3/6
     * @param collection 获取集合
     * @return void
     * @description
     */
    public static  FindIterable<Document> find(  MongoCollection<Document> collection){
        try{
            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
           /* MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }*/
            return findIterable;
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }

    /**
     * 更新文档
     * @author why
     * @date 2019/3/6
     * @param collection 获取集合
     * @return void
     * @description
     */
    public static void updateMany(  MongoCollection<Document> collection){
        try{
            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 删除文档
     * @author why
     * @date 2019/3/6
     * @param collection 获取集合
     *   @param flag   0:删除第一个； 否则删除所有
     * @return void
     * @description  删除符合条件的第一个文档 deleteOne()
     *                 删除所有符合条件的文档  deleteMany()
     */
    public static void remove(  MongoCollection<Document> collection,Integer flag){
        try{
            if (flag==0) {
                //删除符合条件的第一个文档
                collection.deleteOne(Filters.eq("likes", 200));
            }else {
                //删除所有符合条件的文档
                collection.deleteMany(Filters.eq("likes", 200));
            }
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

}

