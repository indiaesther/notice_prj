package com.project.DAO;

public class SearchVO extends PagingVO {
	private String searchOption;
	private String keyword;

	public SearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchVO(int currentPage, int cntPerPage, int pageSize) {
		super(currentPage, cntPerPage, pageSize);
		// TODO Auto-generated constructor stub
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchVO [searchOption=" + searchOption + ", keyword=" + keyword + ", getCurrentPage()=" + getCurrentPage() + ", getCntPerPage()=" + getCntPerPage() + ", getPageSize()=" + getPageSize() + ", getTotalPageCount()=" + getTotalPageCount() + ", getFirstPage()=" + getFirstPage() + ", getLastPage()=" + getLastPage() + ", getFirstRecordIndex()=" + getFirstRecordIndex() + ", getLastRecordIndex()=" + getLastRecordIndex() + ", isHasPreviousPage()=" + isHasPreviousPage() + ", isHasNextPage()=" + isHasNextPage() + ", getTotalRecordCount()=" + getTotalRecordCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
