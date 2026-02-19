package com.example.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoherenceApplication {

    public static void main(String[] args) {
        System.setProperty("coherence.cacheconfig", "coherence-cache-config.xml");

        SpringApplication.run(SpringCoherenceApplication.class, args);

        // Example usage
        NamedCache<String, String> cache =
                CacheFactory.getCache("test-cache");

        cache.put("key1", "Hello Coherence");
        System.out.println("Value from cache: " + cache.get("key1"));
    }
}
