//package com.pps.back.frame.pupansheng.config;
//
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///*import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;*/
//
//@Configuration
//@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
//public class RedisConfig {
//
//
//        @Bean
//        @ConditionalOnClass(RedisTemplate.class)
//        public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
//            RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//            template.setConnectionFactory(factory);
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper om = new ObjectMapper();
//            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            jackson2JsonRedisSerializer.setObjectMapper(om);
//            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//            // key采用String的序列化方式
//            template.setKeySerializer(stringRedisSerializer);
//            // hash的key也采用String的序列化方式
//            template.setHashKeySerializer(stringRedisSerializer);
//            // value序列化方式采用jackson
//            template.setValueSerializer(jackson2JsonRedisSerializer);
//            // hash的value序列化方式采用jackson
//            template.setHashValueSerializer(jackson2JsonRedisSerializer);
//            template.afterPropertiesSet();
//            //开启事务支持
//            template.setEnableTransactionSupport(true);
//            return template;
//        }
//
//       /* @Bean
//        @ConditionalOnClass(Jedis.class)
//        public Jedis jedis(){
//
//            Jedis jedis=new Jedis("192.168.163.3",6379);
//            jedis.auth("pps123");
//            return  jedis;
//        }*/
//
//
//
//
//       /* @Bean(destroyMethod="shutdown")
//        @ConditionalOnClass(RedissonClient.class)
//        public RedissonClient redisson() throws IOException {
//
//            RedissonClient redisson = Redisson.create(
//                    Config.fromYAML(new ClassPathResource("application-redisson.yml").getInputStream()));
//            return redisson;
//
//        }*/
//
//
//
//
//}