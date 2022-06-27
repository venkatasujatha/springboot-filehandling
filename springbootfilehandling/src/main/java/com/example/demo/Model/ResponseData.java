package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResponseData {
	
	@Id
	private int id;
	private String downloadurl;
	private String filetype;
	private long filesize;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDownloadurl() {
		return downloadurl;
	}
	public void setDownloadurl(String downloadurl) {
		this.downloadurl = downloadurl;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public ResponseData(int id, String downloadurl, String filetype, long filesize) {
		super();
		this.id = id;
		this.downloadurl = downloadurl;
		this.filetype = filetype;
		this.filesize = filesize;
	}
	public ResponseData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseData(String filename, Object downloadURL2, String contentType, long size) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseData [id=" + id + ", downloadurl=" + downloadurl + ", filetype=" + filetype + ", filesize="
				+ filesize + "]";
	}
	
	
	

}
