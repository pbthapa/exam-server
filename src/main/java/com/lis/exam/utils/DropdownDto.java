package com.lis.exam.utils;

public class DropdownDto {

	private Long id;
	private String name;
	private boolean checked = false;

	public DropdownDto(Long id, String name, boolean checked) {
		super();
		this.id = id;
		this.name = name;
		this.checked = checked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
