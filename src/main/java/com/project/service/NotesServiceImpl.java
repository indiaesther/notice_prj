package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.NoteDAO;
import com.project.DAO.SearchVO;
import com.project.mapper.NotesMapper;

@Service
public class NotesServiceImpl implements NotesService {

	@Override
	public int getBoardListCnt(SearchVO searchVo) {
		return notesmapper.getBoardListCnt(searchVo);
	}

	@Autowired
	NotesMapper notesmapper;

	@Override
	public int writeBoardInsert(NoteDAO noteDao) {
		// 게시글 등록
		return notesmapper.writeBoardInsert(noteDao);
	}


	@Override
	public List<NoteDAO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return notesmapper.getBoardList();
	}

	@Override
	public List<NoteDAO> getBoardList(SearchVO searchVo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getBoardList Service START");
		System.out.println(searchVo.getKeyword());
		System.out.println("getBoardList Service END");
		return notesmapper.getBoardList(searchVo);
	}


	@Override
	public void deleteBoard(List<Integer> noteIdArray) {
		// 게시글 삭제
		for (int i = 0; i < noteIdArray.size(); i++) {
			notesmapper.deleteBoard(noteIdArray.get(i));
		}
	}

	@Override
	public NoteDAO getDetailNote(Integer noteIdx) {
		// 게시글 상세조회
		NoteDAO noteDao = notesmapper.getDetailNote(noteIdx);
		return noteDao;
	}

	@Override
	public int updateBoard(NoteDAO noteDao) {
		// 게시판 수정
		return notesmapper.updateBoard(noteDao);
	}


}
