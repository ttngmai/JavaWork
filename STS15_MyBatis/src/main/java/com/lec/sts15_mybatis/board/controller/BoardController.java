package com.lec.sts15_mybatis.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.command.BCommand;
import com.lec.sts15_mybatis.board.command.BDeleteCommand;
import com.lec.sts15_mybatis.board.command.BListcommand;
import com.lec.sts15_mybatis.board.command.BSelectCommand;
import com.lec.sts15_mybatis.board.command.BUpdateCommand;
import com.lec.sts15_mybatis.board.command.BViewCommand;
import com.lec.sts15_mybatis.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	private SqlSession sqlsession;
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}
	
	@Autowired
	public void setSqlsession(SqlSession sqlSession) {
		this.sqlsession = sqlSession;
		C.sqlSession = sqlSession;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command = new BListcommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String wrtie(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	@RequestMapping(value = "/view.do")
	public String view(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BViewCommand().execute(model);
		return "board/view";
	}
	
	@RequestMapping(value = "/update.do")
	public String update(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BSelectCommand().execute(model);
		return "board/update";
	}
	
	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
	public String updateOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BUpdateCommand().execute(model);
		return "board/updateOk";
	}
	
	@RequestMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BDeleteCommand().execute(model);
		return "board/deleteOk";
	}
}
