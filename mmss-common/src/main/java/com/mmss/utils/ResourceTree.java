package com.mmss.utils;

import java.util.List;

public class ResourceTree {

	private String id;
	private String text;
	private String icon;
	private String url;
	private List<Tree> menus;
	
	public List<Tree> getMenus() {
		return menus;
	}
	public void setMenus(List<Tree> menus) {
		this.menus = menus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
