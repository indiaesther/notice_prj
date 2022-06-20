package com.project.service;

import java.util.List;

import com.project.DAO.NoteDAO;
import com.project.DAO.SearchVO;

public interface NotesService {

	public int getBoardListCnt(SearchVO searchVo);

	public int writeBoardInsert(NoteDAO noteDao);

	public List<NoteDAO> getBoardList() throws Exception;

	// paging
	public List<NoteDAO> getBoardList(SearchVO searchVo) throws Exception;


	public void deleteBoard(List<Integer> noteIdArray);

	public NoteDAO getDetailNote(Integer noteIdx);

	public int updateBoard(NoteDAO noteDao);

}
