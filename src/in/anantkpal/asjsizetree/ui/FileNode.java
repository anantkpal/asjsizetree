/*
 * This Code Snippet is part Of ASJSizeTree
 * Author: Anant Pal -  anantkpal@yahoo.co.in
 * Copyright (c) 2013,2014 Anant Pal(anantkpal@yahoo.co.in).  All rights reserved.
 */

package in.anantkpal.asjsizetree.ui;

import in.anantkpal.asjsizetree.files.TFile;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TreeItem;

public class FileNode{

private static NumberFormat formatter = new DecimalFormat("#0.0000"); 
	
	private TFile file;
	private TreeItem treeitem;

	public TFile getFile() {
		return file;
	}

	public void setFile(TFile file) {
		this.file = file;
	}
	
	public FileNode(TreeItem parentItem, TFile file) {
		treeitem= new TreeItem(parentItem, SWT.NONE);
		this.file=file;
		treeitem.setText(new String[] { file.getName(), String.valueOf(formatter.format(Double.valueOf(file.getSize())/(1024*1024)))});
	}

	public TreeItem getTreeitem() {
		return treeitem;
	}

	public void setTreeitem(TreeItem treeitem) {
		this.treeitem = treeitem;
	}
}
