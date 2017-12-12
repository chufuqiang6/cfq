package com.cfq.demo.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class RedisSentialTest {
	
    
    public static void main(String[] args) {
    	JedisPoolConfig poolConfig = new JedisPoolConfig();
    	 String masterName = "mymaster";
    	 Set<String> sentinels = new HashSet<String>();
    	 sentinels.add("192.168.6.133:26379");
    	 sentinels.add("192.168.6.135:26380");
         JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, poolConfig);
    	 HostAndPort currentHostMaster = jedisSentinelPool.getCurrentHostMaster();
    	 System.out.println(currentHostMaster.getHost()+"--"+currentHostMaster.getPort());//获取主节点的信息
    	 Jedis resource = jedisSentinelPool.getResource();
    String value = resource.get("username");
      System.out.println(value);//获得键a对应的value值
     resource.close();
	}
}
