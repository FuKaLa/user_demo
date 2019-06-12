package com.example.demo.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.util.*;


/**
 * jedis管理类
 *
 * @author anpushang
 */
public class JedisManager implements RedisConstant {

    private static final Log log = LogFactory.getLog(JedisManager.class);

    private static boolean inited = false;
    public static ShardedJedisPool pool;
    private static JedisPoolConfig poolConfig = new JedisPoolConfig();
    private static GenericObjectPoolConfig poolConfig2 = new GenericObjectPoolConfig();

    private static JedisSentinelPool sentinelPool = null;
    private static JedisCluster jCluster;
    private static String Redis_Pwd = null;
    private static String redisPort = null;

    private static String[] strArray = null;
    private static Integer redisType = null;

    private static JedisManager jedisManager = null;
    private static Object syncRoot=new Object();

    private static JedisPool jedisPool=null;

    public static final synchronized JedisManager getInstance(){
        if(jedisManager==null){
            synchronized (syncRoot){
                if(jedisManager==null){
                    jedisManager=initJedisManager();
                }
            }
        }
        return jedisManager;
    }

    private static JedisManager initJedisManager(){
        log.info("初始化jedis缓存参数");
        //最大活动的对象个数
        //poolConfig.setMaxTotal(RedisConfig.getInt(REDIS_POOL_MAX_TOTAL));
        poolConfig2.setMaxTotal(RedisConfig.getInt(REDIS_POOL_MAX_TOTAL));
        //对象最大空闲时间
        //poolConfig.setMaxIdle(RedisConfig.getInt(REDIS_POOL_MAX_IDLE));
        poolConfig2.setMaxIdle(RedisConfig.getInt(REDIS_POOL_MAX_IDLE));
        //获取对象时最大等待时间
        //poolConfig.setMaxWaitMillis(RedisConfig.getLong(REDIS_POOL_MAX_WAIT_MILLIS));
        poolConfig2.setMaxWaitMillis(RedisConfig.getLong(REDIS_POOL_MAX_WAIT_MILLIS));
        //当调用borrow Object方法时，是否进行有效性检查
        //poolConfig.setTestOnBorrow(RedisConfig.getBoolean(REDIS_POOL_TEST_ON_BORROW));
        poolConfig2.setTestOnBorrow(RedisConfig.getBoolean(REDIS_POOL_TEST_ON_BORROW));

        Redis_Pwd = RedisConfig.getString(REDIS_PWD);
        //不确定可不可以正确使用，如果不可以，侧改用上面一行
        //String pwd= RedisConfig.getString(REDIS_PWD);

        strArray = RedisConfig.getStringArray(REDIS_POOL);
        String ip=null;
        String port=null;
        String[] arr=null;
        if(strArray.length == 1) {
            initShardedJedisPool();//初始化redis缓存池
            jedisManager = new JedisManagerSharded(pool);
            return jedisManager;
        }
        //集群redis缓存池初始化
        if(sentinelPool == null){
            //Set<HostAndPort> jedisHostAndPorts = new HashSet<HostAndPort>();
            Set<String> sentinels = new HashSet<String>();
            //HostAndPort hport = null;
            for (int i = 0; i < strArray.length; i++) {
                arr=strArray[i].split(":");
                ip=arr[0];
                port=arr[1];
                log.info("集群缓存服务器初始化中:"+ip+"==========="+port);
                //hport = new HostAndPort(ip,Integer.parseInt(port));
                //jedisHostAndPorts.add(hport);
                sentinels.add(arr[0]+":"+arr[1]);
                log.info("集群缓存服务器初始化完成:"+ip+"==========="+port+"ip + 端口");
            }
            sentinelPool = new JedisSentinelPool("master7002", sentinels, poolConfig2, Redis_Pwd);
            //jCluster = new JedisCluster(jedisHostAndPorts,150000,5000,6, Redis_Pwd, poolConfig);
            //log.info("jcluster登录,缓存服务器初始化完成jCluster");
            log.info("sentinelPool,缓存服务器初始化完成sentinelPool");
        }
        //jedisManager =  new JedisManagerCluster(jCluster);
        jedisManager = new JdisSentinels(sentinelPool);
        return jedisManager;
    }

    private static void initShardedJedisPool(){
        if(pool!=null){
            return;
        }
        String ip=null;
        String port=null;
        String[] arr=null;
        List<JedisShardInfo> shardJedis = new ArrayList<JedisShardInfo>();
        JedisShardInfo jsi=null;
        log.info("缓存服务器初始化中:"+strArray[0]);
        arr=strArray[0].split(":");
        ip=arr[0];
        port=arr[1];
        jsi=new JedisShardInfo(String.format("http://%s:%s/0",ip,port));
        if(!StringUtils.isBlank(Redis_Pwd))
        {
            jsi.setPassword(Redis_Pwd);
        }
        shardJedis.add(jsi);
        pool = new ShardedJedisPool(poolConfig, shardJedis);
    }

    /**
     * 存储redis的键值不设置时间
     *
     * @param jediskey     redis键
     * @param str  redis值
     */
    public  void setJedisVal(String jediskey, String str) {

    }


    /**
     * 设置时间存储redis
     * @param jediskey key值
     * @param str 保存的string
     * @param liveSeconds 设置存储时间
     * @return
     */
    public  String setString(String jediskey, String str, int liveSeconds) {
        log.info("弗雷");
        return null;
    }

    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String getString(String jediskey) {
        return null;
    }


    /***
     *  将值加入队列
     * @param jediskey
     * @return
     */
    public  Long lPush(String jediskey,String... value) {
        return null;
    }


    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String lPop(String jediskey) {
        return null;
    }

    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String rPop(String jediskey) {
        return null;
    }

    /***
     *  根据key值获取redis存储列表
     * @param jediskey
     * @return
     */
    public  List<String> lRange(String jediskey,int start,int end) {
        return null;
    }

    /***
     *  根据key值获取redis存储列表长度
     * @param jediskey
     * @return
     */
    public  Long lLen(String jediskey) {
        return null;
    }


    /***
     *  根据key值获取redis存储map中列表
     * @param jediskey
     * @return
     */
    public  List<String> hMGet(String jediskey,String _key) {
        return null;
    }

    /***
     *  根据key值获取redis存储map中列表
     * @param jediskey
     * @return
     */
    public  String hGet(String jediskey,String _key) {
        return null;
    }


    /***
     *  存储map到redis
     * @param jediskey
     * @return
     */
    public  void hMSet(String jediskey,Map map) {
    }
    /***
     *  存储key-value到redis
     * @param jediskey
     * @return
     */
    public  void hSet(String jediskey,String field, String value) {
    }

    /***
     * 存储map到redis
     * @param jediskey
     * @param map
     * @param secondValue 缓存时间，秒
     */
    public  void hMSet(String jediskey,Map map, int secondValue) {
    }

    /***
     *  存储map到redis
     * @param jediskey
     * @return
     */
    public  void hDel(String jediskey,String _key) {
    }

    public  long delString(String key) {
        return 0l;
    }

    public  long delStringNew(String key) {
        return 0l;
    }

    public  long delObject(String key) {
        return 0l;
    }

    public  Object getObject(String key) {
        return null;
    }

    public  String setObject(String key, int seconds, Object obj) {
        return null;
    }

    public  byte[] getBytes(byte[] key) {
        return null;
    }

    public  String setBytes(byte[] key, int seconds, byte[] bytes) {
        return null;
    }

    public  String encode(String str) {
        return null;
    }

    /***
     *
     * @param key
     * @return
     */
    public long del(byte[] key) {
        return 0l;
//        if (key == null) {
//            return 0L;
//        }
//        ShardedJedis jedis = null;
//        long ret = 0L;
//        try {
//            jedis = pool.getResource();
//            ret = jedis.del(key).longValue();
//        } catch (Exception e) {
//            log.error(e);
//            ret = -1L;
//        } finally {
//            closeJedis(jedis);
//        }
//        return ret;
    }

    /**
     * 根据redis key for delete
     * @param key
     * @return
     */
    public  long del(String key) {
        return 0l;
    }

    public  long batchDel(String pre_str){
        return 0l;
    }

    public  boolean lock(String key, int seconds) {
        return false;
    }

    public  long incrByStr(String key) {
        return 0l;
    }

    public  long incrByByte(byte[] key) {
        return 0l;
    }

    ///////////////////////////redis操作方法新增///////////////////////////////////////////
    public void save(String key, String value, Integer seconds) {
    }

    public void save(String key, String value) {
    }

    public void delete(String... keys) {
    }

    public boolean update(String key, String value, Integer seconds) {
        return false;
    }

    public String getValue(String key) {
        return null;
    }

    /**
     * 判断KEY是否存在
     * @param key
     * @return 存在返回true 不存在返回false
     */
    public boolean isExists(String key) {
       return false;
    }

    public  Long hset(String key, String field, String value) {
        return 0l;
    }

    public  Long hdel(String key, String...fields) {
        return 0l;
    }

    public  String hmset(String key, Map<String, String> hash) {
        return null;
    }

    public  Map<String, String> hgetAll(String key) {
        return null;
    }

    public  String hget(String key, String field) {
        return null;
    }
    /**
     * 查看哈希表 key 中，给定域 field 是否存在
     * @author liuwei29
     * @param key
     * @param field
     * @return
     */
    public  boolean hexists(String key, String field) {
        return false;
    }

    public  List<String> keys(String keys){
        return null;
    }

    public  Boolean exists(String key) {
        return false;
    }

    public  Long expire(String key, int seconds) {
        return null;
    }

    public  Long zadd(String key, Double score, String member) {
        return null;
    }

    public  Long zcount(String key, Double min, Double max) {
        return null;
    }


    public  Set<String> zrangeByScore(String key, Double min, Double max) {
        return null;
    }

    public  Set<String> zrangeByScore(String key, Double min, Double max, int offset, int count) {
        return null;
    }

    public  Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        return null;
    }

    public  Set<String> zrevrangeByScore(String key, String min, String max, int offset, int count) {
        return null;
    }

    public  Set<String> zrevrangeByScore(String key, Double min, Double max, int offset, int count) {
        return null;
    }

    public  Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        return null;
    }

    public  Double zscore(String key, String member) {
        return null;
    }

    public  Set<String> zrangeByScore(String key, String min, String max) {
        return null;
    }

    public  Set<String> zrevrange(String key, long start, long end) {
        return null;
    }

    public  Set<String> zrange(String key, long start, long end) {
        return null;
    }

    public  Long zrem(String key, String members) {
        return null;
    }

    public  Long lpush(String key, String... strings) {
        return null;
    }

    public  Long lpush(byte[] key, byte[]... strings) {
        return null;
    }

    public  String lpop(String key) {
        return null;
    }

    /**
     * 数据入队, 往队尾入队
     * @param key
     * @param strings
     * @return
     */
    public  Long rpush(String key, String... strings) {
        return null;
    }

    public  byte[] lpop(byte[] key) {
        return null;
    }

    public  Long lrem(String key, long count, String value) {
        return null;
    }

    public  List<String> lrange(String key, long start, long end) {
        return null;
    }

    public  byte[] lindex(byte[] key, long index) {
        return null;
    }

    public  String lindex(String key, long index) {
        return null;
    }

    public  Long sadd(String key, String... members) {
        return null;
    }

    public  Long srem(String key, String... members) {
        return null;
    }

    public  Set<String> smembers(String key) {
        return null;
    }

    /**
     * 判断 member 元素是否集合 key 的成员
     * @param key
     * @param member
     * @return
     */
    public  boolean sismember(String key, String member) {
        return false;
    }

    public  Long incr(String key) {
        return null;
    }

    public  Long hincrby(String key,String field,Long value){
        return null;
    }

    public  String set(String key, String value) {
        return null;
    }

    public  String set(byte[] key, byte[] value) {
        return null;
    }

    public  String get(String key) {
        return null;
    }

    public  byte[] get(byte[] key) {
        return null;
    }
    public String append(String jediskey, String str, int liveSeconds){return null;}
    public String getStringNoEncode(String jediskey){return null;}
    public String setStringNoEncode(String jediskey, String str, int liveSeconds){return null;}
    public long ttl(String jediskey){return 0;}
}
