package de.siteof.cache;

import java.lang.ref.WeakReference;

public class WeakReferenceObjectCacheProxy<K, V> extends ObjectCacheProxy<K, V> {

	public WeakReferenceObjectCacheProxy(IObjectCache<K, V> cache) {
		super(cache);
	}
	
	public static <K, V> IObjectCache<K, V> getInstance(IObjectCache<K, V> cache) {
		return new WeakReferenceObjectCacheProxy<K, V>(cache);
	}

	@Override
	public void put(K key, V value) {
		super.put(key, new WeakReference<V>(value));
	}

}
