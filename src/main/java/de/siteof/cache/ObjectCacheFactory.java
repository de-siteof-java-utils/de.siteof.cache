package de.siteof.cache;

public class ObjectCacheFactory {

	public static <K,V> IObjectCache<K,V> getNewObjectCache() {
		return new ObjectCache<K,V>();
	}

	public static <K,V> IObjectCache<K,V> getNewSoftObjectCache() {
		return new SoftObjectCache<K,V>();
	}

}
