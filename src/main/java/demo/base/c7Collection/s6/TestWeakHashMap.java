package demo.base.c7Collection.s6;

import java.util.WeakHashMap;

/**
 * Description: <br/>
 * Copyright (C), 2005-2008, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap whm = new WeakHashMap();
		// 将WeakHashMap中添加三个key-value对，
		// 三个key都是匿名字符串对象（没有其他引用）
		whm.put(new String("语文"), new String("良好"));
		whm.put(new String("数学"), new String("及格"));
		whm.put(new String("英文"), new String("中等"));
		// 将WeakHashMap中添加一个key-value对，
		// 该key是一个系统缓存的字符串对象。
		whm.put("java", new String("中等"));
		// 输出whm对象，将看到4个key-value对。
		System.out.println(whm);
		// 通知系统立即进行垃圾回收
		System.gc();
		System.runFinalization();
		// 通常情况下，将只看到一个key-value对。
		System.out.println(whm);
	}
}
