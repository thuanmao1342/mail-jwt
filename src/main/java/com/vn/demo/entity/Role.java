package com.vn.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Role implements Serializable{
	@Id
	private String id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy = "roles")
	List<Authority> authorities;
}
