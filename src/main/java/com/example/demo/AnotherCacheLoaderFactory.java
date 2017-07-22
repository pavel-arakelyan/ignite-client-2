package com.example.demo;

import javax.cache.configuration.Factory;

public class AnotherCacheLoaderFactory
		implements Factory<AnotherLoader> {

	private static final long serialVersionUID = 7993486374740146730L;

	public AnotherLoader create() {
		return new AnotherLoader();
	}
}
