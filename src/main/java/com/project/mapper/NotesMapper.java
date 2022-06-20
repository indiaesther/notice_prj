package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.DAO.NoteDAO;
import com.project.DAO.SearchVO;

@Mapper
public interface NotesMapper {

	public int getBoardListCnt(SearchVO searchVo);

	public int writeBoardInsert(NoteDAO noteDao);

	// 게시글 조회
	public List<NoteDAO> getBoardList() throws Exception;

	// 페이징
	public List<NoteDAO> getBoardList(SearchVO searchVo) throws Exception;

	// 게시글 검색 조회
	public List<NoteDAO> searchBoardList(SearchVO searchVo) throws Exception;

	// 게시글 검색 결과 갯수
	public int searchBoardListCnt();

	public int deleteBoard(Integer noteIdx);

	public NoteDAO getDetailNote(int noteIdx);

	public int updateBoard(NoteDAO noteDao);
}
