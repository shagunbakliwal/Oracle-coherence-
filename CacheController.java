package com.example.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final NamedCache<String, String> cache =
            CacheFactory.getCache("test-cache");

    @PostMapping
    public String put(@RequestParam String key,
                      @RequestParam String value) {
        cache.put(key, value);
        return "Stored";
    }

    @GetMapping
    public String get(@RequestParam String key) {
        return cache.get(key);
    }
}
