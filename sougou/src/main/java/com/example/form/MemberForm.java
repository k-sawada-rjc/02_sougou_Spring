package com.example.form;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MemberForm {

	/** ID */
	@NotBlank
	@Length(max = 10)
	private String memberId;
	/** 名前 */
	@NotBlank
	@Length(max = 40)
	private String name;
	/** 年齢 */
	@NotNull
	@Max(999)
	private Integer age;
	/** 住所 */
	@NotBlank
	@Length(max = 50)
	private String address;
	/** 性別 */
	@NotNull
	private Integer sex;
	/** mail */
	@NotNull
	@Email
	@Length(max = 20)
	private String mail;
	/** 電話番号 */
	@Pattern(regexp = "^\\d{11}$", message = "電話番号は11桁の数字で入力してください")
	private String tel;
	/** 役職id */
	private String positionId;
	/** 事業所id */
	private String placeId;
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
}
