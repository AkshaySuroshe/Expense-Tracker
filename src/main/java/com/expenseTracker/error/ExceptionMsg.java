package com.expenseTracker.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMsg {

	private String msg;

	public ExceptionMsg(String msg) {
		super();
		this.msg = msg;
	}
	
}
