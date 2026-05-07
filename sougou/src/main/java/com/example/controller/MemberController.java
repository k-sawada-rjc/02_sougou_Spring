package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.entity.Place;
import com.example.entity.Position;
import com.example.form.MemberForm;
import com.example.service.MemberService;
import com.example.service.PlaceService;
import com.example.service.PositionService;

import jakarta.validation.Valid;

/**
 * @author kazuki_sawada Controllerクラス
 */
@SessionAttributes("member")
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

	@ModelAttribute("positions")
	public List<Position> setPositions() {
	    return positionService.findAll();
	}

	@ModelAttribute("places")
	public List<Place> setPlaces() {
	    return placeService.findAll();
	}

	/**
	 * 一覧機能
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {

		List<Member> memberList = memberService.findAll();
		model.addAttribute("members", memberList);

		return "html/list";
	}

	/**
	 * 新規登録機能 初期表示
	 *
	 * @return
	 */
	@GetMapping("/insert")
	public String insert(Model model) {
		if (!model.containsAttribute("member")) {
			MemberForm form = new MemberForm();
			model.addAttribute("member", form);
		}

		return "html/insert";
	}

	/**
	 * 新規登録機能 確認画面表示
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/insertConf")
	public String insertConf(@Valid @ModelAttribute("member") MemberForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "html/insert";
		}

		form.setPosition(positionService.findById(form.getPositionId()));
		form.setPlace(placeService.findById(form.getPlaceId()));

		return "html/insertConf";
	}

	/**
	 * 新規登録機能 登録完了画面をリダイレクト
	 *
	 * @param form
	 * @param redirAttrs
	 * @param sessionStatus
	 * @return
	 */
	@PostMapping("/insertComp")
	public String insertComp(@ModelAttribute("member") MemberForm form, RedirectAttributes redirAttrs,
			SessionStatus sessionStatus) {

		MemberDto dto = MemberDto.convertFormToDto(form);
		memberService.insert(dto);

		// Sessionに保存されたデータを消去
		sessionStatus.setComplete();

		redirAttrs.addFlashAttribute("completedMember", form);
		return "redirect:/insertCompDone";
	}

	/**
	 * 新規登録機能 登録完了画面表示
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/insertCompDone")
	public String insertCompDone(Model model) {
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

	@PostMapping("/updateConf")
	public String updateConf() {
		return "html/updateConf";
	}

	@PostMapping("/updateComp")
	public String updateComp() {
		return "html/updateComp";
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

	@PostMapping("/deleteConf")
	public String deleteConf() {
		return "html/deleteConf";
	}

	@PostMapping("/deleteComp")
	public String deleteComp() {
		return "html/deleteComp";
	}
}
