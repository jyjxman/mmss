package com.mmss.utils;

import java.io.Serializable;
import java.util.List;

public class DTree implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6074248181180804373L;
	private Long id;
    private String text;
    private String state = "open";// open,closed
    private boolean checked = false;
    private Object attributes;
    private List<DTree> children;
    private String iconCls;
    private Long parentid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Object getAttributes() {
		return attributes;
	}
	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
	
	public List<DTree> getChildren() {
		return children;
	}
	public void setChildren(List<DTree> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
    
    
    
}
