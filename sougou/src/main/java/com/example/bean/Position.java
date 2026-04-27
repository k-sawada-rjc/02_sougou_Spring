package com.example.bean;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_position")
@SQLRestriction("delete_flg = '0'")
public class Position {

	/** 役職ID */
	@Id
	@Column(name = "position_id")
	private String positionId;
	/** 役職名 */
	@Column(name = "position_name")
	private String positionName;

	/**
	 * 役職IDをセットする.
	 *
	 * @param positionId
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * 役職IDを返す.
	 *
	 * @return
	 */
	public String getPositionId() {
		return this.positionId;
	}

	/**
	 * 役職名をセットする.
	 *
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * 役職名を返す.
	 *
	 * @return
	 */
	public String getPositionName() {
		return this.positionName;
	}
}
