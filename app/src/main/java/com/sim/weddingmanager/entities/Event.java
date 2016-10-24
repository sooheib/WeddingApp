package com.sim.weddingmanager.entities;

import garin.artemiy.sqlitesimple.library.annotations.Column;
import garin.artemiy.sqlitesimple.library.util.ColumnType;

public class Event {
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NUMBER = "name";
	public static final String COLUMN_FAMILY = "budget";
	
	@Column(name = COLUMN_ID, type = ColumnType.INTEGER, isPrimaryKey = true, isAutoincrement = true)
	private int id;
	
	@Column(name = COLUMN_NUMBER)
	private String name;
	
	
	@Column(name = COLUMN_FAMILY)
	private String budget;

	/**
	 * 
	 */
	public Event() {
	}

	/**
	 * @param id
	 * @param name
	 * @param budget
	 */
	public Event(int id, String name, String budget) {
		super();
		this.id = id;
		this.name = name;
		this.budget = budget;
	}

	/**
	 * @param name
	 * @param type
	 * @param budget
	 */
	public Event(String name, String budget) {
		super();
		this.name = name;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

}
