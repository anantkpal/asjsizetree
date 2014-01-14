/*
 * This Code Snippet is part Of ASJSizeTree
 * Author: Anant Pal -  anantkpal@yahoo.co.in
 * Copyright (c) 2013,2014 Anant Pal(anantkpal@yahoo.co.in).  All rights reserved.
 */


package in.anantkpal.asjsizetree;

import in.anantkpal.asjsizetree.files.TFolder;
import in.anantkpal.asjsizetree.ui.FolderNode;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class BootStrap {
	private static Text filePath;
	private static Tree tableTree;
	
	public static void main(String[] args) {
		Display display = new Display ();
		final Shell shell = new Shell(display);
		
		shell.setLayout(new GridLayout(3,false));
		shell.setText("ASJSizeTree");
		shell.setMinimumSize(377, 777);
		
		filePath = new Text(shell, SWT.BORDER);
		filePath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button browseButton = new Button(shell, SWT.PUSH);
		browseButton.setText("Browse..");
		browseButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				DirectoryDialog fd = new DirectoryDialog(shell, SWT.OPEN);
				fd.setText("Open");
				filePath.setText(fd.open());
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {}
		});
		
		Button loadButton = new Button(shell, SWT.PUSH);
		loadButton.setText("LOAD..");
		loadButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				tableTree.removeAll();
				TFolder folder = new TFolder(filePath.getText());
				FolderNode child = new FolderNode(tableTree, folder);
				child.createTreeElements();
				tableTree.redraw();
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {}
		});
	    // Create the TableTree and set some attributes on the underlying table
	    tableTree = new Tree(shell,  SWT.NONE);
	    tableTree.setSize(350, 700);
	    tableTree.setHeaderVisible(true);
	    TreeColumn column1 = new TreeColumn(tableTree, SWT.LEFT);
	    column1.setText("Name (Folder/File)");
	    column1.setWidth(277);
	    TreeColumn column2 = new TreeColumn(tableTree, SWT.CENTER);
	    column2.setText("Size(in MBs)");
	    column2.setWidth(100);
	    
	    GridData data = new GridData(GridData.FILL_BOTH);
	    data.horizontalSpan=3;
	    data.grabExcessHorizontalSpace=true;
	    tableTree.setLayoutData(data);
	    
	 
	
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
