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
		    
		// 可以取得資訊    
		System.out.println(immutableFoo.getFoo());    
			    
		// 可透過immutableFoo來移去foo所參考實例內的資訊    
		immutableFoo.setFoo(null);    
		    
		// 不可透過immutableFoo來設定新的資訊給foo所參考的實例    
		// 所以下面這行無法通過編譯    
//		 immutableFoo.setFoo("John");
	}
	
}