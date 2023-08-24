package com.jiangc.practice.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = -2867495993196030595L;

	@JsonProperty("data")
	private final T data;
	
	@JsonProperty("status")
	private final String status;
	
	@JsonProperty("message")
	private final String message;
	
	public T getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}

	public static final class Builder {
		
		private Object data;
		
		private final String status;
		
		private final String msg;

		public Builder(String status, String msg) {
			this.status = status;
			this.msg = msg;
		}
		
		public Builder setObj(Object data) {
			this.data = data;
			return this;
		}
		
		public Builder setData(Object data) {
			this.data = data;
			return this;
		}
		
		public BaseResponse build() {
            return new BaseResponse(this.data == null ? "" : this.data, this.status, this.msg);
        }
	}

}
