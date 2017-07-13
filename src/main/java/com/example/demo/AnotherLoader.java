package com.example.demo;

import java.io.Serializable;
import java.util.Map;

import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;

/**
 * @author pavel.arakelyan on 7/10/17.
 */
public class AnotherLoader implements CacheLoader<String, String>, Serializable{

	public String load(String s) throws CacheLoaderException {
		return s;
	}

	public Map<String, String> loadAll(Iterable<? extends String> iterable) throws CacheLoaderException {
		throw new UnsupportedOperationException("asdasdasdasd");
	}
}
