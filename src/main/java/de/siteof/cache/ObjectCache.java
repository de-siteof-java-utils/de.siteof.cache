package de.siteof.cache;

import java.util.HashMap;
import java.util.Map;

public class ObjectCache<K,V> extends AbstractMapObjectCache<K,V> {

	private final Map<K,Object> map	= new HashMap<K,Object>();

	@Override
	protected Map<K,Object> getMap() {
		return map;
	}

}
