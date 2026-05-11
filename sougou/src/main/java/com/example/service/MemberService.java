package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.form.MemberForm;
import com.example.repository.MemberRepository;

/**
 * @author kazuki_sawada Serviceクラス
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	private PositionService positionService;

	@Autowired
	private PlaceService placeService;

	/**
	 * 全件取得
	 *
	 * @return
	 */
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member findById(String id) {
		return memberRepository.findById(id).get();
	}

	/**
	 * 新規登録機能
	 *
	 * @param dto
	 */
	public void insert(MemberDto dto) {

		// 登録日,更新日,削除フラグをセット
		dto.setRegist(LocalDateTime.now());
		dto.setUpdate(LocalDateTime.now());
		dto.setDeleteFlg(0);

		Member member = MemberDto.convertDtoToEntity(dto);

		memberRepository.save(member);
	}

	/**
	 * 更新機能
	 *
	 * @param dto
	 */
	public void update(MemberDto dto) {

		// 更新日をセット
		dto.setUpdate(LocalDateTime.now());

		Member member = MemberDto.convertDtoToEntity(dto);
		memberRepository.save(member);
	}

	/**
	 * 削除機能
	 * @param dto
	 */
	public void delete(MemberDto dto) {

		Member member= MemberDto.convertDtoToEntity(dto);
		member.setDeleteFlg(1);
		memberRepository.save(member);
	}

	/**
	 * formに役職と事業所をセット
	 *
	 * @param form
	 * @return
	 */
	public MemberForm setSelect(MemberForm form) {
		form.setPosition(positionService.findById(form.getPositionId()));
		form.setPlace(placeService.findById(form.getPlaceId()));
		return form;
	}
}
