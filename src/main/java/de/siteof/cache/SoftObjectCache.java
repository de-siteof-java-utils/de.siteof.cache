package de.siteof.cache;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SoftObjectCache<K,V> extends AbstractMapObjectCache<K,V> {

	private Reference<Map<K,Object>> reference	= null;

	private static final Log log	= LogFactory.getLog(SoftObjectCache.class);


	protected Map<K,Object> getMap() {
		Map<K,Object> result	= null;
		if (reference != null) {
			result	= reference.get();
		}
		if (result == null) {
			log.debug("creating new cache hash map");
			result	= new HashMap<K,Object>();
			reference	= new SoftReference<Map<K,Object>>(result);
		}
		return result;
	}
}
