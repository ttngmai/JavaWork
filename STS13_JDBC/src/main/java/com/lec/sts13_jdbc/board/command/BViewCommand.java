package com.lec.sts13_jdbc.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		BWriteDAO dao = new BWriteDAO();
		BWriteDTO dto = dao.readByUid(uid);
		model.addAttribute("list", Arrays.asList(dto));
		
		// Arrays.asList(new String[]{"aaa", "bbb"})
		// Arrays.asList("aaa", "bbb")
	}

}
