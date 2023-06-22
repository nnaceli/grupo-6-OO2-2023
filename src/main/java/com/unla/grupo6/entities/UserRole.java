package com.unla.grupo6.entities;

//import java.time.LocalDateTime;
//
//import org.hibernate.annotations.CreationTimestamp;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.UniqueConstraint;

//@Entity
//@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "user_id" }))
//public class UserRole {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;
//
//	@Column(name = "role", nullable = false, length = 100)
//	private String role;
//
//	@Column(name = "createdat")
//	@CreationTimestamp
//	private LocalDateTime createdAt;
//
//	@Column(name = "updateat")
//	@CreationTimestamp
//	private LocalDateTime updateAt;
//
//	// constructor vacio gus no usa!
//
//	public UserRole() {
//		super();
//	}
//	
//
//	// constructor
//	//constructor gus le saca lso createdate y updateAt
////		public UserRole(int id, User user, String role) {
////			super();
////			this.id = id;
////			this.user = user;
////			this.role = role;
////		}
////		
//		
//
//	//cosntructor completo
//	public UserRole(int id, User user, String role, LocalDateTime createdAt, LocalDateTime updateAt) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.role = role;
//		this.createdAt = createdAt;
//		this.updateAt = updateAt;
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
////metodos accesores
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDateTime getUpdateAt() {
//		return updateAt;
//	}
//
//	public void setUpdateAt(LocalDateTime updateAt) {
//		this.updateAt = updateAt;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//}


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="user_role", uniqueConstraints=@UniqueConstraint(columnNames= {"role", "user_id"}))
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	@Column(name="role", nullable=false, length=100)
	private String role; 

	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	

	public UserRole(int id, User user, String role) {
		this.id = id;
		this.user = user;
		this.role = role;
	}
	
}
