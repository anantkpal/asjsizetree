/*
 * This Code Snippet is part Of ASJSizeTree
 * Author: Anant Pal -  anantkpal@yahoo.co.in
 * Copyright (c) 2013,2014 Anant Pal(anantkpal@yahoo.co.in).  All rights reserved.
 */

package in.anantkpal.asjsizetree.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TFolder extends File {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<TFolder> folders = new ArrayList<TFolder>();
	private List<TFile> files = new ArrayList<TFile>();
	
	public TFolder(String pathname) {
		super(pathname);
		File[] filez=this.listFiles();
		for (File file : filez) {
			if(file.isDirectory()){
				folders.add(new TFolder(file.getAbsolutePath()));
			}else{
				files.add(new TFile(file.getAbsolutePath()));
			}
		}
	}

	public List<TFolder> getFolders() {
		return folders;
	}

	public void setFolders(List<TFolder> folders) {
		this.folders = folders;
	}

	public List<TFile> getFiles() {
		return files;
	}

	public void setFiles(List<TFile> files) {
		this.files = files;
	}

	
	public long getSize(){
		long size=0L;
		for (TFolder folder : folders) {
			size+=folder.getSize();
		}
		for (TFile file : files) {
			size+=file.getSize();
		}
		return size;
	}
	

}
