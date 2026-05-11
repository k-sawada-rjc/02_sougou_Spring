package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		model.addAttribute("member", new MemberForm());
		return "html/insert";
	}

	/**
	 * 新規登録機能 戻るボタン押下時
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(@ModelAttribute("member") MemberForm form, Model model) {
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

		form = memberService.setSelect(form);
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
	public String insertComp(@ModelAttribute("member") MemberForm form, RedirectAttributes redirAttrs) {

		form = memberService.setSelect(form);

		MemberDto dto = MemberDto.convertFormToDto(form);
		memberService.insert(dto);

		redirAttrs.addFlashAttribute("member", form);
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
	@PostMapping("/detail/{id}")
	public String detail(Model model, @PathVariable(value = "id") String id) {

		Member member = memberService.findById(id);
		MemberDto dto = MemberDto.convertEntityToDto(member);
		MemberForm form = MemberDto.convertDtoToForm(dto);
		memberService.setSelect(form);

		model.addAttribute("member", form);
		return "html/detail";
	}

	/**
	 * 更新機能 初期表示
	 *
	 * @return
	 */
	@PostMapping("/update/{id}")
	public String update(Model model, @PathVariable(value = "id") String id) {

		MemberDto dto = MemberDto.convertEntityToDto(memberService.findById(id));
		model.addAttribute("member", MemberDto.convertDtoToForm(dto));

		return "html/update";
	}

	/**
	 * 更新機能 戻るボタン押下時
	 *
	 * @param form
	 * @return
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute("member") MemberForm form) {
		return "html/update";
	}

	/**
	 * 更新機能 確認画面表示
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateConf")
	public String updateConf(@Valid @ModelAttribute("member") MemberForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "html/update";
		}

		form = memberService.setSelect(form);
		return "html/updateConf";
	}

	/**
	 * 更新機能 更新完了画面をリダイレクト
	 *
	 * @return
	 */
	@PostMapping("/updateComp")
	public String updateComp(@ModelAttribute("member") MemberForm form, RedirectAttributes redirAttrs) {

		form = memberService.setSelect(form);

		MemberDto dto = MemberDto.convertFormToDto(form);
		memberService.update(dto);

		redirAttrs.addFlashAttribute("member", form);
		return "redirect:/updateCompDone";
	}

	/**
	 * 更新機能 更新完了画面表示
	 *
	 * @return
	 */
	@GetMapping("/updateCompDone")
	public String updateCompDone() {
		return "html/updateComp";
	}

	/**
	 * 削除機能 初期表示
	 *
	 * @return
	 */
	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable(value = "id") String id) {

		Member member = memberService.findById(id);
		MemberDto dto = MemberDto.convertEntityToDto(member);
		MemberForm form = MemberDto.convertDtoToForm(dto);
		memberService.setSelect(form);

		model.addAttribute("member", form);
		return "html/delete";
	}

	/**
	 * 削除機能 削除完了画面をリダイレクト
	 *
	 * @return
	 */
	@PostMapping("/deleteComp")
	public String deleteComp(@ModelAttribute("member") MemberForm form, RedirectAttributes redirAttrs) {

		memberService.setSelect(form);
		MemberDto dto = MemberDto.convertFormToDto(form);
		memberService.delete(dto);

		redirAttrs.addFlashAttribute("member", form);
		return "redirect:/deleteCompDone";
	}

	/**
	 * 削除機能 削除完了画面表示
	 *
	 * @return
	 */
	@GetMapping("/deleteCompDone")
	public String deleteCompDone() {
		return "html/deleteComp";
	}
}
