package com.project.controller;

import java.io.File;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.DAO.NoteDAO;
import com.project.DAO.SearchVO;
import com.project.service.NotesService;


@Controller
@RequestMapping("/")
public class WriteNotesController {

	@Autowired
	NotesService notesService;

	/*
	 * 게시글 조회 최초진입 화면
	 */

	@RequestMapping("/view")
	public String viewNotes(SearchVO searchVo, Model model) throws Exception {

		System.out.println("====viewNotes Controller START=====");

		int totalCnt = notesService.getBoardListCnt(searchVo);
		searchVo.setTotalRecordCount(totalCnt);

		System.out.println(searchVo.toString());

		model.addAttribute("notesList", notesService.getBoardList(searchVo));
		model.addAttribute("pagingVo", searchVo);

		System.out.println("====viewNotes Controller END=====");
		return "viewNotes";
	}


	/*
	 * 게시글 작성폼 최종수정일: 2022-05-16 안쓰는거임
	 */
	@RequestMapping("/form")
	public String writeNotesForm(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage, Model model) {
		System.out.println("===writeNotesForm Start===");

		model.addAttribute("currentPage", currentPage);

		System.out.println("===writeNotesForm End===");

		return "writeNotes";
	}


	/*
	 * 게시글 쓰기 최종수정일: 2022-05-16
	 */
	@RequestMapping("/insert")
	public String writeNotes(NoteDAO noteDao, MultipartFile[] uploadFile, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage, Model model) throws Exception {
		System.out.println("===writeNotes Controller START===");
		System.out.println(noteDao.toString());

		String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
		String basePath = rootPath + "/" + "multi";

		if (uploadFile.length != 0) {
			for (MultipartFile file : uploadFile) {
				if (file.getSize() != 0) {
					String org_file_nm = file.getOriginalFilename();
					String filePath = basePath + "/" + org_file_nm;

					System.out.println("파일명 >>" + file.getOriginalFilename());
					System.out.println("확장자 >>" + file.getContentType());

					File dest = new File(filePath);
					file.transferTo(dest);
				}
			}

		}

		model.addAttribute("currentPage", currentPage);

		notesService.writeBoardInsert(noteDao);
		System.out.println("===writeNotes Controller END===");
		return "writeNotes";
	}

	/*
	 * 게시글 삭제 최종수정일: 2022-05-16
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteNotes(SearchVO searchVo, @RequestParam(value = "noteIdArray[]") List<Integer> noteIdArray) {

		System.out.println("---> 삭제할 게시글 ID ");
		for (int i = 0; i < noteIdArray.size(); i++) {
			System.out.println("---> " + noteIdArray.get(i));
		}
		notesService.deleteBoard(noteIdArray);

	}


	/*
	 * 게시글 상세보기 최종수정일: 2022-05-17
	 */
	@RequestMapping("/detailView")
	public ModelAndView getDetailNote(SearchVO searchVo, @RequestParam(value = "noteId") String noteId) {
		System.out.println("===getDetailNote Controller START===");

		NoteDAO noteDao = new NoteDAO();
		noteDao.setNoteID(Integer.parseInt(noteId));

		ModelAndView mv = new ModelAndView();

		noteDao = notesService.getDetailNote(noteDao.getNoteID());
		System.out.println(noteDao.toString());
		System.out.println(searchVo.toString());
		mv.addObject("noteDao", noteDao);
		mv.addObject("searchVo", searchVo);
		mv.setViewName("detailNotes");

		System.out.println("===getDetailNote Controller END===");
		return mv;
	}

	/*
	 * 게시글 수정 최종수정일: 2022-05-17
	 */
	@RequestMapping("/updateNote")
	@ResponseBody
	public ModelAndView updateNote(NoteDAO noteDao, MultipartFile[] uploadFile) throws Exception {
		System.out.println("===updateNote Start===");
		System.out.println("---> 수정할 게시글 ID  => " + noteDao.getNoteID());
		System.out.println(noteDao.toString());

		String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
		String basePath = rootPath + "/" + "multi";

		if (uploadFile.length != 0) {
			for (MultipartFile file : uploadFile) {
				if (file.getSize() != 0) {
					String org_file_nm = file.getOriginalFilename();
					String filePath = basePath + "/" + org_file_nm;

					System.out.println("파일명 >>" + file.getOriginalFilename());
					System.out.println("확장자 >>" + file.getContentType());

					File dest = new File(filePath);
					file.transferTo(dest);
				}
			}
		}

		ModelAndView mv = new ModelAndView("redirect:/view");
		notesService.updateBoard(noteDao);

		System.out.println("===updateNote End===");
		return mv;
	}


}
