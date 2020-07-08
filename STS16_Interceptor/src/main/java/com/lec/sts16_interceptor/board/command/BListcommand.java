package com.lec.sts16_interceptor.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BListcommand implements BCommand {

	@Override
	public void execute(Model model) {
		BWriteDAO dao = new BWriteDAO();
		List<BWriteDTO> list = dao.select();
		model.addAttribute("list", list);
	}

}
