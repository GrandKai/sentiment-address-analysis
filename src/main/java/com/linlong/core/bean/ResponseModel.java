package com.linlong.core.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Validated
@JsonInclude(Include.NON_NULL)
public class ResponseModel<T> {
	private Date timestamp = new Date();

	private static final Integer SUCCESS_CODE = 0;
	private static final String SUCCESS_MESSAGE = "成功";

	@NonNull
	private Integer code;
	@NonNull
	private String message;
	private T content;

	public ResponseModel() {
		this.code = SUCCESS_CODE;
		this.message = SUCCESS_MESSAGE;
	}

	public ResponseModel(T content) {
		this.code = SUCCESS_CODE;
		this.message = SUCCESS_MESSAGE;
		this.content = content;
	}

	public ResponseModel(String message) {
		this.code = SUCCESS_CODE;
		this.message = message;
	}

	public ResponseModel(String message, T content) {
		this.code = SUCCESS_CODE;
		this.message = message;
		this.content = content;
	}

	public ResponseModel(Integer code, String message, T content) {
		this.code = code;
		this.message = message;
		this.content = content;
	}
}