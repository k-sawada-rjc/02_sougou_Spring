package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bean.MemberBean;
import com.example.bean.Place;
import com.example.bean.Position;
import com.example.service.MemberService;
import com.example.service.PlaceService;
import com.example.service.PositionService;

/**
 * @author kazuki_sawada Controllerクラス
 */
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private PlaceService placeService;

	/**
	 * 初期表示
	 *
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 一覧機能
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {

		List<MemberBean> memberList = memberService.findAll();
		List<Position> positionList = positionService.findAll();
		List<Place> placeList = placeService.findAll();

		model.addAttribute("members", memberList);
		model.addAttribute("positions", positionList);
		model.addAttribute("places", placeList);

		return "html/list";
	}

	/**
	 * 新規登録機能
	 *
	 * @return
	 */
	@GetMapping("/insert")
	public String insert() {
		return "html/insert";
	}

	@GetMapping("/insertComf")
	public String insertComf() {
		return "html/insertComp";
	}

	@GetMapping("/insertComp")
	public String insertComp() {
		return "html/insertComp";
	}

	/**
	 * 詳細機能
	 *
	 * @return
	 */
	@PostMapping("/detail")
	public String detail() {
		return "html/detail";
	}

	/**
	 * 更新機能
	 *
	 * @return
	 */
	@PostMapping("/update")
	public String update() {
		return "html/update";
	}

	@GetMapping("/updateConf")
	public String updateConf() {
		return "html/updateConf";
	}

	@GetMapping("/updateConp")
	public String updateConp() {
		return "html/updateConp";
	}

	/**
	 * 削除機能
	 *
	 * @return
	 */
	@PostMapping("/delete")
	public String delete() {
		return "html/delete";
	}

	@GetMapping("/deleteConf")
	public String deleteConf() {
		return "html/deleteConf";
	}

	@GetMapping("/deleteConp")
	public String deleteConp() {
		return "html/deleteConp";
	}
}
