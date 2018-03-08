package hashmap;

import java.util.HashMap;
import java.util.Map;

public class DualHashMap<K,V> implements DualMap<K, V>{

	  private Map<K, V> KMap;

	  private Map<V, K> VMap;

	  

	   public DualHashMap() {

	       KMap = new HashMap<K, V>();

	       VMap = new HashMap<V , K>();

	   }


	   @Override

	   public void put(K key, V value) {

	       if( KMap.containsKey(key) || KMap.containsValue(value) || VMap.containsValue(key) || VMap.containsKey(value))

	       {

	           remove(key, value);

	       }

	       KMap.put(key, value);

	       VMap.put(value, key);

	   }
	   

	   @Override

	   public void remove(K key, V value) {

	       KMap.remove(key);

	       VMap.remove(value);

	   }
	   

	   @Override

	   public V get(K key) {

	       return KMap.get(key);

	   }
	   

	   @Override

	   public K reverseGet(V value) {

	       return VMap.get(value);

	   }

	}