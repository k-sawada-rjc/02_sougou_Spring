package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Beanクラス
 *
 * @author RJC Human Resources
 */
@Entity
@Table(name = "tbl_member")
@SQLRestriction("delete_flg = '0'")
public class Member {

	/** ID */
	@Id
	@Column(name = "member_id")
	private String memberId;
	/** 名前 */
	@Column(name = "member_name")
	private String name;
	/** 年齢 */
	@Column(name = "age")
	private Integer age;
	/** 住所 */
	@Column(name = "address")
	private String address;
	/** 性別 */
	@Column(name = "sex_flg")
	private Integer sex;
	/** mail */
	@Column(name = "mail")
	private String mail;
	/** 電話番号 */
	@Column(name = "telephone")
	private String tel;
	/** 役職id */
	@Column(name = "position_id")
	private String positionId;
	/** 役職 */
	@OneToOne
	@JoinColumn(name = "position_id", insertable = false, updatable = false)
	Position position;
	/** 事業所id */
	@Column(name = "place_id")
	private String placeId;
	/** 事業所 */
	@OneToOne
	@JoinColumn(name = "place_id", insertable = false, updatable = false)
	Place place;
	/** 登録日 */
	@Column(name = "regist_date")
	private LocalDateTime regist;
	/** 更新日 */
	@Column(name = "update_date")
	private LocalDateTime update;
	/** 削除フラグ */
	@Column(name = "delete_flg")
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
}
