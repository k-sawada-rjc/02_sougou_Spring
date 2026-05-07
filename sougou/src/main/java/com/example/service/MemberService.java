package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bean.MemberBean;
import com.example.dto.MemberDto;
import com.example.repository.MemberRepository;

/**
 * @author kazuki_sawada Serviceクラス
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	/**
	 * 全件取得
	 *
	 * @return
	 */
	public List<MemberBean> findAll() {
		return memberRepository.findAll();
	}

	public void insert(MemberDto dto) {

		dto.setRegist(LocalDateTime.now());
		MemberBean member = MemberDto.convertDtoToEntity(dto);

		memberRepository.save(member);
	}
}
