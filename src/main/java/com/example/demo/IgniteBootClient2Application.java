package com.example.demo;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan
public class IgniteBootClient2Application {
//
//	@Autowired
//	CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(IgniteBootClient2Application.class, args);
	}

	public void run(String... strings) throws Exception {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setPeerClassLoadingEnabled(true);
		Ignition.setClientMode(true);
		Ignite ignite = Ignition.start(cfg);
		IgniteCache<String, String> cache = ignite.getOrCreateCache(new CacheConfiguration<String, String>()
				.setName("test-cache").setCacheLoaderFactory(new AnotherCacheLoaderFactory()).setReadThrough(true));
		System.out.println(cache.get("Aasd"));
	}

}
