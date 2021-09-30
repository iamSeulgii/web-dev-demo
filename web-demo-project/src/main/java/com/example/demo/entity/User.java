package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {
	@Id
	@Column(nullable=false, unique=true, length=30)
	private String loginId;
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Column(nullable=false, length=100)
	private String password;
	
}
