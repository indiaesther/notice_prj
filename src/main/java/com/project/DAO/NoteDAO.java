package com.project.DAO;

import java.util.Date;

public class NoteDAO extends PagingVO {

	private int noteID;
	private String title;
	private String brandNm;
	private String categoryNm;
	private String popupYn;
	private String contents;
	private Date regDate;
	private Date modDate;
	private String useYn;



	public NoteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteDAO(int currentPage, int cntPerPage, int pageSize) {
		super(currentPage, cntPerPage, pageSize);
		// TODO Auto-generated constructor stub
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandNm() {
		return brandNm;
	}

	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public String getPopupYn() {
		return popupYn;
	}

	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "NoteDAO [noteID=" + noteID + ", title=" + title + ", brandNm=" + brandNm + ", categoryNm=" + categoryNm + ", popupYn=" + popupYn + ", contents=" + contents + ", regDate=" + regDate + ", modDate=" + modDate + ", useYn=" + useYn + "]";
	}

}
