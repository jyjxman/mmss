package com.mmss.utils;

import java.io.Serializable;

public class OtherResult implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1514097462801824141L;
		public static final int SUCCESS = 1;
	    public static final int FAILURE = -1;

	   

	    private boolean success = false;

	    private String msg = "";

	    private Object obj = null;

	    public boolean isSuccess() {
	        return success;
	    }

	    public void setSuccess(boolean success) {
	        this.success = success;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public Object getObj() {
	        return obj;
	    }

	    public void setObj(Object obj) {
	        this.obj = obj;
	    }

}
