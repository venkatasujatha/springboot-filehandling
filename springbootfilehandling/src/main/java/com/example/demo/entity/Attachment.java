package com.example.demo.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Attachment {
	@Id
	private int id;
	private String filename;
	private String filetype;
	@Lob
	private byte[] data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public Attachment(String filename, String filetype, byte[] data) {
		super();
		this.id = id;
		this.filename = filename;
		this.filetype = filetype;
		this.data = data;
	}
	public Attachment(int i, String filename2, String string, byte[] bs) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", filename=" + filename + ", filetype=" + filetype + ", data="
				+ Arrays.toString(data) + "]";
	}
	
	
}
