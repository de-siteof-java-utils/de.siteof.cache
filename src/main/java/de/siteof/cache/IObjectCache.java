package de.siteof.cache;

import java.lang.ref.Reference;

public interface IObjectCache<K,V> {

	V get(K key);

	void put(K key, V value);
	
	void put(K key, Reference<V> valueReference);

	void remove(K key);

	void clear();

}
