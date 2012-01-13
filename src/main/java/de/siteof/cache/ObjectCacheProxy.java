package de.siteof.cache;

import java.lang.ref.Reference;

public class ObjectCacheProxy<K, V> implements IObjectCache<K, V> {
	
	private final IObjectCache<K, V> cache;
	
	public ObjectCacheProxy(IObjectCache<K, V> cache) {
		this.cache = cache;
	}

	@Override
	public void clear() {
		this.cache.clear();
	}

	@Override
	public V get(K key) {
		return this.cache.get(key);
	}

	@Override
	public void put(K key, V value) {
		this.cache.put(key, value);
	}

	@Override
	public void put(K key, Reference<V> valueReference) {
		this.cache.put(key, valueReference);
	}

	@Override
	public void remove(K key) {
		this.cache.remove(key);
	}

}
