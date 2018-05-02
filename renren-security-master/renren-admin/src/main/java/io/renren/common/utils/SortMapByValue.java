package io.renren.common.utils;

import java.util.*;

/**
 * map按值排序
 * @author ryanyang
 * @date 2018-4-26
 */
@SuppressWarnings("unchecked")

public class SortMapByValue {
	
	public static Map sortByValue(Map map) {
	    List list = new LinkedList(map.entrySet());
	    Collections.sort(list, new Comparator() {
	 
	      public int compare(Object o1, Object o2) {
	        return ((Comparable) ((Map.Entry) (o1)).getValue())
	            .compareTo(((Map.Entry) (o2)).getValue());
	 
	      }
	    });
	   
		Map result = new LinkedHashMap();
	 
	    for (Iterator it = list.iterator(); it.hasNext();) {
	      Map.Entry entry = (Map.Entry) it.next();
	      result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	  }
	 
	  public static Map sortByValue(Map map, final boolean reverse) {
	    List list = new LinkedList(map.entrySet());
	    Collections.sort(list, new Comparator() {
	 
	      public int compare(Object o1, Object o2) {
	        if (reverse) {
	          return -((Comparable) ((Map.Entry) (o1)).getValue())
	              .compareTo(((Map.Entry) (o2)).getValue());
	        }
	        return ((Comparable) ((Map.Entry) (o1)).getValue())
	            .compareTo(((Map.Entry) (o2)).getValue());
	      }
	    });
	 
	    Map result = new LinkedHashMap();
	    for (Iterator it = list.iterator(); it.hasNext();) {
	      Map.Entry entry = (Map.Entry) it.next();
	      result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	  }
	 

}
