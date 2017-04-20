package com.latihan.siacademic.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "FRSDetails")
public class FRSDetails implements Serializable{
		
		private static final long serialVersionUID = -7893237204476214050L;
		private Integer id;
		private FRS frsId;
		private Subject sbjId;
		
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name="id", nullable=false)
		public Integer getId(){
			return id;
		}
		public void setId(Integer id){
			this.id = id;
		}
		
		@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
		@JoinColumn (name="frsId", nullable = false, foreignKey = @ForeignKey(name="FRSDetails_fk1"))
		public FRS getFrsId() {
			return frsId;
		}
		public void setFrsId(FRS frsId) {
			this.frsId = frsId;
		}
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn (name="sbjId", nullable = false, foreignKey = @ForeignKey(name="FRSDetails_fk2"))
		public Subject getSbjId() {
			return sbjId;
		}
		public void setSbjId(Subject sbjId) {
			this.sbjId = sbjId;
		}
}
