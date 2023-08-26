package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sec_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role extends BaseEntity {
@Enumerated(EnumType.STRING)
	private userRole role;
}
