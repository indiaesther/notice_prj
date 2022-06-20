package com.project.DAO;

import java.util.Date;

public class FileDAO {
	private int file_no;
	private int noteID;
	private String org_file_nm;
	private String stored_file_nm;
	private int file_size;
	private Date reg_date;
	private String useYn;

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getOrg_file_nm() {
		return org_file_nm;
	}

	public void setOrg_file_nm(String org_file_nm) {
		this.org_file_nm = org_file_nm;
	}

	public String getStored_file_nm() {
		return stored_file_nm;
	}

	public void setStored_file_nm(String stored_file_nm) {
		this.stored_file_nm = stored_file_nm;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "FileDAO [file_no=" + file_no + ", noteID=" + noteID + ", org_file_nm=" + org_file_nm + ", stored_file_nm=" + stored_file_nm + ", file_size=" + file_size + ", reg_date=" + reg_date + ", useYn=" + useYn + "]";
	}

}
