package demo.base.c7Collection.s3;

import java.util.TreeSet;

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
class Err {
}

public class TestTreeSetError {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		// ��TreeSet��������������Err����
		ts.add(new Err());
		ts.add(new Err());
	}
}