package com.matrixport.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericFoo<T> {
	private T foo;

	public void setFoo(T foo) {
		this.foo = foo;
	}

	public T getFoo() {
		return foo;
	}
	
	public static void main(String[] args) {
//		GenericFoo<? extends List> foo = null;  
//		foo = new GenericFoo<LinkedList>();
//		foo = new GenericFoo<ArrayList>();
		
		GenericFoo<String> foo = new GenericFoo<String>();    
		foo.setFoo("caterpillar");    
		GenericFoo<?> immutableFoo = foo;    
		    
		// ����ȡ���YӍ    
		System.out.println(immutableFoo.getFoo());    
			    
		// ��͸�^immutableFoo����ȥfoo�����������ȵ��YӍ    
		immutableFoo.setFoo(null);    
		    
		// ����͸�^immutableFoo���O���µ��YӍ�ofoo�������Č���    
		// ���������@�Пo��ͨ�^���g    
//		 immutableFoo.setFoo("John");
	}
	
}