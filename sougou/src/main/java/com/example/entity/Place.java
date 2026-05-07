package com.example.entity;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_place")
@SQLRestriction("delete_flg = '0'")
public class Place {

	/** 事務所ID */
	@Id
	@Column(name = "place_id")
	private String placeId;
	/** 事務所名 */
	@Column(name = "place_name")
	private String placeName;

	/**
	 * 事務所IDをセットする.
	 *
	 * @param placeId
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * 事務所IDを返す.
	 *
	 * @return
	 */
	public String getPlaceId() {
		return this.placeId;
	}

	/**
	 * 事務所名をセットする.
	 *
	 * @param pleceName
	 */
	public void setPlaceName(String pleceName) {
		this.placeName = pleceName;
	}

	/**
	 * 事務所名を返す.
	 *
	 * @return
	 */
	public String getPlaceName() {
		return this.placeName;
	}
}
