package de.siteof.cache;


public class SynchronizedObjectCache<K,V> extends ObjectCache<K,V> {


	public V get(K key) {
		V result;
		synchronized(this) {
			result	= super.get(key);
		}
		return result;
	}


	public void put(K key, V value) {
		synchronized(this) {
			super.put(key, value);
		}
	}

	/* (non-Javadoc)
	 * @see de.siteof.webpicturebrowser.cache.ObjectCache#clear()
	 */
	public void clear() {
		synchronized(this) {
			super.clear();
		}
	}

}
