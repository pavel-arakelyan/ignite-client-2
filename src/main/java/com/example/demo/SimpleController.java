package com.example.demo;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pavel.arakelyan on 7/12/17.
 */
@RestController
public class SimpleController {

	IgniteCache<String, String> cache;

	public SimpleController() {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setPeerClassLoadingEnabled(true);
		Ignition.setClientMode(true);
		Ignite ignite = Ignition.start(cfg);
		cache = ignite.getOrCreateCache(new CacheConfiguration<String, String>()
				.setName("test-cache").setCacheLoaderFactory(new AnotherCacheLoaderFactory()).setReadThrough(true));

	}

	@RequestMapping("client2/{key}")
	public String get(@PathVariable String key){
		return cache.get(key);
	}

}
