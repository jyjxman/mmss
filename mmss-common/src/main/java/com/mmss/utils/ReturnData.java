package com.mmss.utils;

import java.io.Serializable;

/**
 * 返回数据格式
 * @author Mr.Wang
 *
 */
public class ReturnData implements Serializable {
	
	private static final long serialVersionUID = -7273927060673714829L;
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
