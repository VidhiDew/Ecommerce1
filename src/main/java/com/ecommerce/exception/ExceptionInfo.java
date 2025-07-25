package com.ecommerce.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionInfo {

	private String code;
	private String msg;
	private LocalDateTime date;
}
