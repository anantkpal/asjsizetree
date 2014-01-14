/*
 * This Code Snippet is part Of ASJSizeTree
 * Author: Anant Pal -  anantkpal@yahoo.co.in
 * Copyright (c) 2013,2014 Anant Pal(anantkpal@yahoo.co.in).  All rights reserved.
 */

package in.anantkpal.asjsizetree.ui;

import in.anantkpal.asjsizetree.files.TFile;
import in.anantkpal.asjsizetree.files.TFolder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class FolderNode{
	
	private static NumberFormat formatter = new DecimalFormat("#0.0000"); 
	
	private TFolder folder;
	private TreeItem treeitem;

	public FolderNode(TreeItem parentItem, TFolder folder) {
		treeitem = new TreeItem(parentItem, SWT.NONE);
		this.folder=folder;
		treeitem.setText(new String[] { folder.getName(), String.valueOf(formatter.format(Double.valueOf(folder.getSize())/(1024*1024)))});
	}
	
	
	public FolderNode(Tree parent, TFolder folder) {
		treeitem = new TreeItem(parent, SWT.NONE);
		this.folder=folder;
		treeitem.setText(new String[] { folder.getName(), String.valueOf(formatter.format(Double.valueOf(folder.getSize())/(1024*1024)))});

	}


	public TFolder getFolder() {
		return folder;
	}


	public void setFolder(TFolder folder) {
		this.folder = folder;
	}
	
	
	public void createTreeElements(){
			List<TFolder> folderz= folder.getFolders();
			for (TFolder foldr : folderz) {
				FolderNode folderNode = new FolderNode(treeitem, foldr);
				folderNode.createTreeElements();
			}
			List<TFile> filz= folder.getFiles();
			for (TFile fil : filz) {
				new FileNode(treeitem, fil);
			}	
	}


	public TreeItem getTreeitem() {
		return treeitem;
	}


	public void setTreeitem(TreeItem treeitem) {
		this.treeitem = treeitem;
	}
	
}
