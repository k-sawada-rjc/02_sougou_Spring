package com.example.dto;

import java.time.LocalDateTime;

import com.example.entity.Member;
import com.example.entity.Place;
import com.example.entity.Position;
import com.example.form.MemberForm;

public class MemberDto {

	/** ID */
	private String memberId;
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** 住所 */
	private String address;
	/** 性別 */
	private Integer sex;
	/** mail */
	private String mail;
	/** 電話番号 */
	private String tel;
	/** 役職id */
	private String positionId;
	/** 役職名 */
	Position position;
	/** 事業所id */
	private String placeId;
	/** 事業所名 */
	Place place;
	/** 登録日 */
	private LocalDateTime regist;
	/** 更新日 */
	private LocalDateTime update;
	/** 削除フラグ */
	private Integer deleteFlg;

	/**
	 * IDを取得します。
	 *
	 * @return ID
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * IDを設定します。
	 *
	 * @param memberId ID
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 名前を取得します。
	 *
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前を設定します。
	 *
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 年齢を取得します。
	 *
	 * @return 年齢
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 年齢を設定します。
	 *
	 * @param age 年齢
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 住所を取得します。
	 *
	 * @return 住所
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住所を設定します。
	 *
	 * @param address 住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 性別を取得します。
	 *
	 * @return 性別
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 性別を設定します。
	 *
	 * @param sex 性別
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * mailを取得します。
	 *
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * mailを設定します。
	 *
	 * @param mail mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 電話番号を取得します。
	 *
	 * @return 電話番号
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 電話番号を設定します。
	 *
	 * @param tel 電話番号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 役職idを取得します。
	 *
	 * @return 役職id
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * 役職idを設定します。
	 *
	 * @param positionId 役職id
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * 役職を取得します。
	 *
	 * @return 役職
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * 役職を設定します。
	 *
	 * @param position 役職
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * 事業所idを取得します。
	 *
	 * @return 事業所id
	 */
	public String getPlaceId() {
		return placeId;
	}

	/**
	 * 事業所idを設定します。
	 *
	 * @param placeId 事業所id
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * 事業所を取得します。
	 *
	 * @return 事業所
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * 事業所を設定します。
	 *
	 * @param place 事業所
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * 登録日を取得します。
	 *
	 * @return 登録日
	 */
	public LocalDateTime getRegist() {
		return regist;
	}

	/**
	 * 登録日を設定します。
	 *
	 * @param regist 登録日
	 */
	public void setRegist(LocalDateTime regist) {
		this.regist = regist;
	}

	/**
	 * 更新日を取得します。
	 *
	 * @return 更新日
	 */
	public LocalDateTime getUpdate() {
		return update;
	}

	/**
	 * 更新日を設定します。
	 *
	 * @param regist 更新日
	 */
	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}

	/**
	 * 削除フラグを取得します。
	 *
	 * @return
	 */
	public Integer getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * 削除フラグを設定します。
	 *
	 * @param deleteFlg
	 */
	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public static final MemberForm convertDtoToForm(MemberDto memberDto) {
		MemberForm memberForm=new MemberForm();

		memberForm.setMemberId(memberDto.getMemberId());
		memberForm.setName(memberDto.getName());
		memberForm.setAge(memberDto.getAge());
		memberForm.setAddress(memberDto.getAddress());
		memberForm.setSex(memberDto.getSex());
		memberForm.setMail(memberDto.getMail());
		memberForm.setTel(memberDto.getTel());
		memberForm.setPositionId(memberDto.getPositionId());
		memberForm.setPosition(memberDto.getPosition());
		memberForm.setPlaceId(memberDto.getPlaceId());
		memberForm.setPlace(memberDto.getPlace());
		memberForm.setRegist(memberDto.getRegist());
		memberForm.setUpdate(memberDto.getUpdate());
		memberForm.setDeleteFlg(memberDto.getDeleteFlg());

		return memberForm;
	}

	public static final MemberDto convertFormToDto(MemberForm memberForm) {
		MemberDto memberDto = new MemberDto();

		memberDto.setMemberId(memberForm.getMemberId());
		memberDto.setName(memberForm.getName());
		memberDto.setAge(memberForm.getAge());
		memberDto.setAddress(memberForm.getAddress());
		memberDto.setSex(memberForm.getSex());
		memberDto.setMail(memberForm.getMail());
		memberDto.setTel(memberForm.getTel());
		memberDto.setPositionId(memberForm.getPositionId());
		memberDto.setPosition(memberForm.getPosition());
		memberDto.setPlaceId(memberForm.getPlaceId());
		memberDto.setPlace(memberForm.getPlace());
		memberDto.setRegist(memberForm.getRegist());
		memberDto.setUpdate(memberForm.getUpdate());
		memberDto.setDeleteFlg(memberForm.getDeleteFlg());

		return memberDto;

	}

	public static final MemberDto convertEntityToDto(Member member) {
		MemberDto memberDto = new MemberDto();

		memberDto.setMemberId(member.getMemberId());
		memberDto.setName(member.getName());
		memberDto.setAge(member.getAge());
		memberDto.setAddress(member.getAddress());
		memberDto.setSex(member.getSex());
		memberDto.setMail(member.getMail());
		memberDto.setTel(member.getTel());
		memberDto.setPositionId(member.getPositionId());
		memberDto.setPosition(member.getPosition());
		memberDto.setPlaceId(member.getPlaceId());
		memberDto.setPlace(member.getPlace());
		memberDto.setRegist(member.getRegist());
		memberDto.setUpdate(member.getUpdate());
		memberDto.setDeleteFlg(member.getDeleteFlg());

		return memberDto;
	}

	public static Member convertDtoToEntity(MemberDto memberDto) {
		Member member = new Member();

		member.setMemberId(memberDto.getMemberId());
		member.setName(memberDto.getName());
		member.setAge(memberDto.getAge());
		member.setAddress(memberDto.getAddress());
		member.setSex(memberDto.getSex());
		member.setMail(memberDto.getMail());
		member.setTel(memberDto.getTel());
		member.setPositionId(memberDto.getPositionId());
		member.setPosition(memberDto.getPosition());
		member.setPlaceId(memberDto.getPlaceId());
		member.setPlace(memberDto.getPlace());
		member.setRegist(memberDto.getRegist());
		member.setUpdate(memberDto.getUpdate());
		member.setDeleteFlg(memberDto.getDeleteFlg());

		return member;
	}
}
