    package com.cache.service;

    import com.fasterxml.jackson.core.JsonProcessingException;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import lombok.extern.slf4j.Slf4j;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.redis.core.RedisTemplate;
    import org.springframework.stereotype.Service;

    import java.util.concurrent.TimeUnit;

    @Service
    @Slf4j
    public class RedisService {
        private static final Logger log = LoggerFactory.getLogger(RedisService.class);
        @Autowired
        private final RedisTemplate redisTemplate;

        public RedisService(RedisTemplate redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        public <T> T get(String key, Class<T> entityClass) {
            try {
                Object o = redisTemplate.opsForValue().get(key);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(o.toString(), entityClass);

            }
            catch (Exception e) {
                log.error("exception ", e);
                return null;
            }
        }

        public void set(String key, Object value, Long ttl) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String str = objectMapper.writeValueAsString(value);
                redisTemplate.opsForValue().set(key, str, ttl, TimeUnit.SECONDS);

            } catch (Exception e) {
                log.error("exception ", e);
            }
        }
    }
