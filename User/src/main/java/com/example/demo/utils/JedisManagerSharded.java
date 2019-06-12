package com.example.demo.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Tuple;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


/**
 * jedis管理类
 *
 * @author anpushang
 */
public class JedisManagerSharded extends JedisManager {

    private static final Log log = LogFactory.getLog(JedisManagerSharded.class);

    private static ShardedJedisPool pool;

    JedisManagerSharded(ShardedJedisPool pool){
        this.pool = pool;
    }




    /**
     * 初始化切片池
     *
     * @param prop
     */
//    public  void initShardedPool(Properties prop) {
//        log.info("JedisManager initConf...");
//        destroy();
//        //读取配置文件，构建redispool,格式：192.168.1.200,192.168.1.64 端口号默认
//        String[] strArray = prop.getProperty(REDIS_POOL).split(",");
//        Set<>
//
//        List<JedisShardInfo> shardJedis = new ArrayList<JedisShardInfo>();
//        for (int i = 0; i < strArray.length; i++) {
//            shardJedis.add(new JedisShardInfo(strArray[i]));
//        }
//
//
//        jCluster = new JedisCluster();
//        pool = new ShardedJedisPool(poolConfig, shardJedis);
//    }


    /**
     * 存储redis的键值不设置时间
     *
     * @param jediskey     redis键
     * @param str  redis值
     */
    public  void setJedisVal(String jediskey, String str) {
        setString(jediskey, str, 0);
    }


    /**
     * 设置时间存储redis
     * @param jediskey key值
     * @param str 保存的string
     * @param liveSeconds 设置存储时间
     * @return
     */
    public  String setString(String jediskey, String str, int liveSeconds) {
        if ((StringUtils.isEmpty(jediskey )) || (StringUtils.isEmpty(str )))
            return null;
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            if(jedis==null)
            {
                System.out.println("未获取到缓存对象.");
            }
            if (liveSeconds <= 0)
                //永久保存
                ret = jedis.set(encode(jediskey), str);
            else
                //设置有效期
                ret = jedis.setex(encode(jediskey), liveSeconds, str);
        } catch (Exception e) {
            System.out.println("缓存设置发生异常");
            log.error("key:" + jediskey + "redis存储出错.",e);
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String getString(String jediskey) {
        if(StringUtils.isEmpty(jediskey)){
            return null;
        }
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.get(encode(jediskey));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的值.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }


    /***
     *  将值加入队列
     * @param jediskey
     * @return
     */
    public  Long lPush(String jediskey,String... value) {
        ShardedJedis jedis = null;
        Long ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.lpush(encode(jediskey), value);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能 lpush值..");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }


    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String lPop(String jediskey) {
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.lpop(encode(jediskey));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的值.");;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  根据key值获取redis存储内容
     * @param jediskey
     * @return
     */
    public  String rPop(String jediskey) {
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.rpop(encode(jediskey));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的值.");;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  根据key值获取redis存储列表
     * @param jediskey
     * @return
     */
    public  List<String> lRange(String jediskey,int start,int end) {
        ShardedJedis jedis = null;
        List<String> ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.lrange(encode(jediskey), start, end);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的列表.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  根据key值获取redis存储列表长度
     * @param jediskey
     * @return
     */
    public  Long lLen(String jediskey) {
        ShardedJedis jedis = null;
        Long ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.llen(encode(jediskey));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的列表长度值.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }


    /***
     *  根据key值获取redis存储map中列表
     * @param jediskey
     * @return
     */
    public  List<String> hMGet(String jediskey,String _key) {
        ShardedJedis jedis = null;
        List<String> ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.hmget(encode(jediskey), encode(_key));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的map中列表.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  根据key值获取redis存储map中列表
     * @param jediskey
     * @return
     */
    public  String hGet(String jediskey,String _key) {
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.hget(encode(jediskey), encode(_key));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的map中列表.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }


    /***
     *  存储map到redis
     * @param jediskey
     * @return
     */
    public  void hMSet(String jediskey,Map map) {
        ShardedJedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.hmset(encode(jediskey), map);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能存储map到redis.");
        } finally {
            closeJedis(jedis);
        }
    }
    /***
     *  存储key-value到redis
     * @param jediskey
     * @return
     */
    public  void hSet(String jediskey,String field, String value) {
        ShardedJedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.hset(encode(jediskey), field, value);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能存储map到redis.");
        } finally {
            closeJedis(jedis);
        }
    }

    /***
     * 存储map到redis
     * @param jediskey
     * @param map
     * @param secondValue 缓存时间，秒
     */
    public  void hMSet(String jediskey,Map map, int secondValue) {
        ShardedJedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.hmset(encode(jediskey), map);
            jedis.expire(jediskey, secondValue);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能存储map到redis.");
        } finally {
            closeJedis(jedis);
        }
    }

    /***
     *  存储map到redis
     * @param jediskey
     * @return
     */
    public  void hDel(String jediskey,String _key) {
        ShardedJedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.hdel(encode(jediskey), encode(_key));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能存储map到redis.");
        } finally {
            closeJedis(jedis);
        }
    }

    public  long delString(String key) {
        return del(encode(key));
    }

    public  long delStringNew(String key) {
        return del(encode(key));
    }

    public  long delObject(String key) {
        return del(key);
    }

    public  Object getObject(String key) {
        if (key == null)
            return null;
        byte[] ret = getBytes(key.getBytes());
        if (ret == null)
            return null;
        return ObjectBytesExchange.toObject(ret);
    }

    public  String setObject(String key, int seconds, Object obj) {
        if ((key == null) || (obj == null))
            return null;
        byte[] byteObj = ObjectBytesExchange.toByteArray(obj);
        if (null == byteObj)
            return null;
        return setBytes(key.getBytes(), seconds, byteObj);
    }

    public  byte[] getBytes(byte[] key) {
        if (key == null)
            return null;
        ShardedJedis jedis = null;
        byte[] ret = null;
        try {
            jedis = (ShardedJedis) pool.getResource();
            ret = jedis.get(key);
        } catch (Exception e) {
            log.error("缓存对象获取失败.",e);
        } finally {
            if (jedis != null) pool.returnResource(jedis);
        }
        return ret;
    }

    public  String setBytes(byte[] key, int seconds, byte[] bytes) {
        if ((key == null) || (bytes == null))
            return null;
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = (ShardedJedis) pool.getResource();
            if (seconds <= 0)
                ret = jedis.set(key, bytes);
            else
                ret = jedis.setex(key, seconds, bytes);
        } catch (Exception e) {
            log.error(e);
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public  String encode(String str) {
        String ret = null;
        if (str != null) {
            try {
                ret = URLEncoder.encode(str, REDIS_ENCODE);
            } catch (UnsupportedEncodingException e) {
                log.error(e);
            }
        }
        return ret;
    }

    /***
     *
     * @param key
     * @return
     */
    public long del(byte[] key) {
        return del(new String(key));
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
        if (key == null) {
            return 0L;
        }
        ShardedJedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            ret = jedis.del(key).longValue();
        } catch (Exception e) {
            log.error(e);
            ret = -1L;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public  long batchDel(String pre_str){
        if (pre_str == null) {
            return 0L;
        }
        ShardedJedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();

            Collection<Jedis> jedisC = jedis.getAllShards();
            Iterator<Jedis> iter = jedisC.iterator();
            long count = 0;
            while (iter.hasNext()) {
                Jedis _jedis = iter.next();
                Set<String> keys = _jedis.keys(pre_str + "*");
                count += _jedis.del(keys.toArray(new String[keys.size()]));
            }
            return count;
        } catch (Exception e) {
            log.error(e);
            ret = -1L;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public  boolean lock(String key, int seconds) {
        if (seconds <= 0) {
            seconds = 21600;
        }
        boolean result = false;
        if (key == null)
            return result;
        ShardedJedis jedis = null;
        long currentTime = System.currentTimeMillis();
        long expireTime = currentTime + seconds * 1000;
        try {
            jedis = pool.getResource();
            if (jedis.setnx(encode(key), String.valueOf(expireTime)).longValue() == 1L) {
                result = true;
                jedis.expire(encode(key), seconds);
            } else {
                Long oldExpireTime = Long.valueOf(getString(encode(key)));
                if ((oldExpireTime != null) && (currentTime > oldExpireTime.longValue() + 300000L)) {
                    del(encode(key));
                    if (jedis.setnx(encode(key), String.valueOf(expireTime)).longValue() == 1L) {
                        result = true;
                        jedis.expire(encode(key), seconds);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            closeJedis(jedis);
        }
        return result;
    }

    public  long incrByStr(String key) {
        if (key == null) {
            return 0L;
        }
        ShardedJedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            ret = jedis.incr(encode(key)).longValue();
        } catch (Exception e) {
            log.error(e);
            ret = -1L;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public  long incrByByte(byte[] key) {
        if ((key == null) || (key.length == 0)) {
            return 0L;
        }
        ShardedJedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            ret = jedis.incr(key).longValue();
        } catch (Exception e) {
            log.error(e);
            ret = -1L;
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }



    /**
     * 释放异常的连接对象
     *
     * @param jedis
     * @return void
     * @throws
     * @Title:closeShardedJedis
     */
    private void closeBrokenJedis(ShardedJedis jedis) {
        if (null != jedis) {
            pool.returnBrokenResource(jedis);
        }

    }

    private ShardedJedis getJedis() {
        ShardedJedis jedis = null;
        // 捕捉异常
        try {
            jedis = pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取Jedis连接失败!:");
        }
        return jedis;
    }

    /**
     * 释放连接对象
     *
     * @param jedis
     * @return void
     * @throws
     * @Title:closeShardedJedis
     */
    private void closeJedis(ShardedJedis jedis) {
        if (null != jedis) {
            pool.returnResource(jedis);
        }
    }

    ///////////////////////////redis操作方法新增///////////////////////////////////////////
    public void save(String key, String value, Integer seconds) {
        ShardedJedis jedis = getJedis();
        try {
            jedis.set(key, value);
            if(seconds!=null){
                jedis.expire(key, seconds);
            }
        } catch (Exception e) {
            //pool.returnBrokenResource(jedis);
            closeBrokenJedis(jedis);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public void save(String key, String value) {
        save(key,value,null);
    }

    public void delete(String... keys) {
        ShardedJedis jedis = getJedis();
        try {
            if (null != keys && keys.length > 0)
                for (int i = 0; i < keys.length; i++)
                    jedis.del(keys[i]);
        } catch (Exception e) {
            //pool.returnBrokenResource(jedis);
            closeBrokenJedis(jedis);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public boolean update(String key, String value, Integer seconds) {
        ShardedJedis jedis = getJedis();
        try {
            if (jedis.exists(key)) {
                jedis.set(key, value);
                jedis.expire(key, seconds);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            //pool.returnBrokenResource(jedis);
            closeBrokenJedis(jedis);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
        return false;
    }

    public String getValue(String key) {
        ShardedJedis jedis = getJedis();
        try {
            if (jedis.exists(key)) {
                return jedis.get(key);
            } else {
                return null;
            }
        } catch (Exception e) {
            //pool.returnBrokenResource(jedis);
            closeBrokenJedis(jedis);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
        return null;
    }

    /**
     * 判断KEY是否存在
     * @param key
     * @return 存在返回true 不存在返回false
     */
    public boolean isExists(String key) {
        boolean rebool = false;
        ShardedJedis jedis = getJedis();
        try {
            rebool = jedis.exists(key);
        } catch (Exception e) {
            //pool.returnBrokenResource(jedis);
            closeBrokenJedis(jedis);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
        return rebool;
    }

    public  Long hset(String key, String field, String value) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hset(key, field, value);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long hdel(String key, String...fields) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hdel(key, fields);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String hmset(String key, Map<String, String> hash) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hmset(key, hash);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Map<String, String> hgetAll(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hgetAll(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String hget(String key, String field) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hget(key, field);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }
    /**
     * 查看哈希表 key 中，给定域 field 是否存在
     * @author liuwei29
     * @param key
     * @param field
     * @return
     */
    public  boolean hexists(String key, String field) {
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hexists(key, field);
        } catch (Exception e) {
            return false;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public  List<String> keys(String keys){
        ShardedJedis jedis=null;
        List<String> result=new ArrayList<>();
        try {
            jedis = pool.getResource();

            Collection<Jedis> jedisC = jedis.getAllShards();
            Iterator<Jedis> iter = jedisC.iterator();

            long count = 0;
            while (iter.hasNext()) {
                Jedis _jedis = iter.next();
                Set<String> _keys = _jedis.keys(keys);
                result.addAll(_keys);
            }
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
        return result;
    }

    public  Boolean exists(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.exists(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long expire(String key, int seconds) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.expire(key, seconds);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long zadd(String key, Double score, String member) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zadd(key, score, member);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long zcount(String key, Double min, Double max) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zcount(key, min, max);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }


    public  Set<String> zrangeByScore(String key, Double min, Double max) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrangeByScore(key, min, max);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrangeByScore(String key, Double min, Double max, int offset, int count) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrangeByScore(key, min, max, offset, count);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrevrangeByScore(String key, String min, String max, int offset, int count) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrevrangeByScore(String key, Double min, Double max, int offset, int count) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Double zscore(String key, String member) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zscore(key, member);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrangeByScore(String key, String min, String max) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrangeByScore(key, min, max);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrevrange(String key, long start, long end) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrevrange(key, start, end);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> zrange(String key, long start, long end) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrange(key, start, end);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long zrem(String key, String members) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.zrem(key, members);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long lpush(String key, String... strings) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lpush(key, strings);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long lpush(byte[] key, byte[]... strings) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lpush(key, strings);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String lpop(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lpop(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    /**
     * 数据入队, 往队尾入队
     * @param key
     * @param strings
     * @return
     */
    public  Long rpush(String key, String... strings) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.rpush(key, strings);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  byte[] lpop(byte[] key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lpop(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long lrem(String key, long count, String value) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lrem(key, count, value);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  List<String> lrange(String key, long start, long end) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lrange(key, start, end);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  byte[] lindex(byte[] key, long index) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lindex(key, index);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String lindex(String key, long index) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.lindex(key, index);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long sadd(String key, String... members) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.sadd(key, members);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long srem(String key, String... members) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.srem(key, members);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Set<String> smembers(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.smembers(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    /**
     * 判断 member 元素是否集合 key 的成员
     * @param key
     * @param member
     * @return
     */
    public  boolean sismember(String key, String member) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.sismember(key, member);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long incr(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.incr(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  Long hincrby(String key,String field,Long value){
        ShardedJedis jedis = getJedis();
        try {
            return jedis.hincrBy(key,field,value);
        } finally {
            closeJedis(jedis);
        }
    }

    public  String set(String key, String value) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.set(key, value);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String set(byte[] key, byte[] value) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.set(key, value);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  String get(String key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.get(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public  byte[] get(byte[] key) {
        ShardedJedis jedis = getJedis();
        try {
            return jedis.get(key);
        } finally {
            //pool.returnResource(jedis);
            closeJedis(jedis);
        }
    }

    public String append(String jediskey, String str, int liveSeconds) {
        if ((StringUtils.isEmpty(jediskey )) || (StringUtils.isEmpty(str )))
            return null;
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            if(jedis==null)
            {
                System.out.println("未获取到缓存对象.");
            }
            if(jedis.exists(jediskey)){
                ret = jedis.append(jediskey, str).toString();
            }
            else {
                if (liveSeconds <= 0)
                    //永久保存
                    ret = jedis.set(jediskey, str);
                else
                    //设置有效期
                    ret = jedis.setex(jediskey, liveSeconds, str);
            }

        } catch (Exception e) {
            System.out.println("缓存设置发生异常");
            log.error("key:" + jediskey + "redis存储出错.",e);
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public String getStringNoEncode(String jediskey) {
        if(StringUtils.isEmpty(jediskey)){
            return null;
        }
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            ret = jedis.get(jediskey);
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能取到redis的值.");
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    public String setStringNoEncode(String jediskey, String str, int liveSeconds) {
        if ((StringUtils.isEmpty(jediskey )) || (StringUtils.isEmpty(str )))
            return null;
        ShardedJedis jedis = null;
        String ret = null;
        try {
            jedis = pool.getResource();
            if(jedis==null)
            {
                System.out.println("未获取到缓存对象.");
            }
            if (liveSeconds <= 0)
                //永久保存
                ret = jedis.set(jediskey, str);
            else
                //设置有效期
                ret = jedis.setex(jediskey, liveSeconds, str);
        } catch (Exception e) {
            System.out.println("缓存设置发生异常");
            log.error("key:" + jediskey + "redis存储出错.",e);
        } finally {
            closeJedis(jedis);
        }
        return ret;
    }

    /***
     *  查询key的失效时间 单位秒
     *  -2：key不存在； -1：存在，但未设置剩余生存时间； 否则，以秒为单位返回key的生存时间。
     * @param jediskey
     * @return
     */
    public long ttl(String jediskey) {
        ShardedJedis jedis = null;
        long ttl = -2l;
        try {
            jedis = pool.getResource();
            ttl = jedis.ttl(encode(jediskey));
        } catch (Exception e) {
            log.error("key:" + jediskey + "未能获取到过期时间.");
        } finally {
            closeJedis(jedis);
        }
        return ttl;
    }



}
