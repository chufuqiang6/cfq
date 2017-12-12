package com.cfq.demo.entity;


public class BaseResult <T> {
    private String resultMsg;//返回消息
    private T data ;//返回数据
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
