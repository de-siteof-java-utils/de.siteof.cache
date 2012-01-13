package de.siteof.cache;

import java.lang.ref.Reference;
import java.util.Map;

public abstract class AbstractMapObjectCache<K,V> implements IObjectCache<K,V> {

	protected abstract Map<K,Object> getMap();

//	protected Map<Object,K> getReverseMap() {
//		throw new UnsupportedOperationException("getReverseMap not implemented");
//	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		V result;
		final Map<K,Object> map	= getMap();
		Object o = map.get(key);
		if (o instanceof Reference) {
			result	= ((Reference<V>) o).get();
			if (result == null) {
				map.remove(key);
			}
		} else {
			result = (V) o;
		}
		return result;
	}

	@Override
	public void put(K key, V value) {
		final Map<K,Object> map	= getMap();
		if (value != null) {
			map.put(key, value);
		} else {
			remove(key);
		}
	}

	@Override
	public void put(K key, Reference<V> valueReference) {
		final Map<K,Object> map	= getMap();
		if (valueReference != null) {
			map.put(key, valueReference);
		} else {
			remove(key);
		}
	}

	@Override
	public void clear() {
		final Map<K,Object> map	= getMap();
		map.clear();
	}

	@Override
	public void remove(Object key) {
		final Map<K,Object> map	= getMap();
		map.remove(key);
	}
}
