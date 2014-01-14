/*
 * This Code Snippet is part Of ASJSizeTree
 * Author: Anant Pal -  anantkpal@yahoo.co.in
 * Copyright (c) 2013,2014 Anant Pal(anantkpal@yahoo.co.in).  All rights reserved.
 */

package in.anantkpal.asjsizetree.files;

import java.io.File;

public class TFile extends File {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public TFile(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}
	
	
	public long getSize(){
		return this.length();
	}

}
