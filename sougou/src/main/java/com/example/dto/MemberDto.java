package com.example.dto;

import java.time.LocalDateTime;

import com.example.bean.MemberBean;
import com.example.bean.Place;
import com.example.bean.Position;
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
	 * 役職名を取得します。
	 *
	 * @return 役職名
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * 役職名を設定します。
	 *
	 * @param position 役職名
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
	 * 事業所名を取得します。
	 *
	 * @return 事業所名
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * 事業所名を設定します。
	 *
	 * @param place 事業所名
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
		memberDto.setPlaceId(memberForm.getPlaceId());
		memberDto.setRegist(memberForm.getRegist());

		return memberDto;

	}

	public static final MemberDto convertEntityToDto(MemberBean memberBean) {
		MemberDto memberDto = new MemberDto();

		memberDto.setMemberId(memberBean.getMemberId());
		memberDto.setName(memberBean.getName());
		memberDto.setAge(memberBean.getAge());
		memberDto.setAddress(memberBean.getAddress());
		memberDto.setSex(memberBean.getSex());
		memberDto.setMail(memberBean.getMail());
		memberDto.setTel(memberBean.getTel());
		memberDto.setPositionId(memberBean.getPositionId());
		memberDto.setPosition(memberBean.getPosition());
		memberDto.setPlaceId(memberBean.getPlaceId());
		memberDto.setPlace(memberBean.getPlace());
		memberDto.setRegist(memberBean.getRegist());

		return memberDto;
	}

	public static MemberBean convertDtoToEntity(MemberDto dto) {
		MemberBean memberBean=new MemberBean();

		memberBean.setMemberId(dto.getMemberId());
		memberBean.setName(dto.getName());
		memberBean.setAge(dto.getAge());
		memberBean.setAddress(dto.getAddress());
		memberBean.setSex(dto.getSex());
		memberBean.setMail(dto.getMail());
		memberBean.setTel(dto.getTel());
		memberBean.setPositionId(dto.getPositionId());
		memberBean.setPosition(dto.getPosition());
		memberBean.setPlaceId(dto.getPlaceId());
		memberBean.setPlace(dto.getPlace());
		memberBean.setRegist(dto.getRegist());


		return memberBean;
	}
}
