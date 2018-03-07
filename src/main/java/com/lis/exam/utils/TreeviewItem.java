package com.lis.exam.utils;

public class TreeviewItem {

	private TreeItem treeItem;
	private boolean autoCorrectChecked = false;

	public TreeItem getTreeItem() {
		if(treeItem == null) {
			return new TreeItem();
		}
		return treeItem;
	}

	public void setTreeItem(TreeItem treeItem) {
		this.treeItem = treeItem;
	}

	public boolean isAutoCorrectChecked() {
		return autoCorrectChecked;
	}

	public void setAutoCorrectChecked(boolean autoCorrectChecked) {
		this.autoCorrectChecked = autoCorrectChecked;
	}

}

class TreeItem {
	private String text;
	private Integer value;
	private boolean disabled = false;
	private boolean checked = false;
	private boolean collapsed = true;
	private TreeItem[] children;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

	public TreeItem[] getChildren() {
		return children;
	}

	public void setChildren(TreeItem[] children) {
		this.children = children;
	}
}
