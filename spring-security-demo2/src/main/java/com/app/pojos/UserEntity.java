package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sec_users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity extends BaseEntity {
@Column(length = 20,unique = true)
private String userName;
@Column(length = 20,unique = true)
private String email;
public UserEntity(String userName, String email, String password) {
	super();
	this.userName = userName;
	this.email = email;
	this.password = password;
}

@Column(length = 300)
private String password;
private boolean active;

//UserEntity *----->*Role
@ManyToMany(fetch = FetchType.EAGER)//acceptable max size of many(role) is 2
@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"),
inverseJoinColumns = @JoinColumn(name="role_id"))
private Set<Role> role=new HashSet<>();
}
