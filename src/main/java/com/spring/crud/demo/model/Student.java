package com.spring.crud.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Student implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	private int rollNo;
	private String firstName;
	private String lastName;
	private float marks;
	
}
