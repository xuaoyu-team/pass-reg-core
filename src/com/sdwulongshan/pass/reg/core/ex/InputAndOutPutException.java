/*
 * Copyright (c) 2021 Mango.
pass-reg-core is licensed under Mulan PubL v2.
You can use this software according to the terms and conditions of the Mulan PubL v2.
You may obtain a copy of Mulan PubL v2 at:
         http://license.coscl.org.cn/MulanPubL-2.0
THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
See the Mulan PubL v2 for more details.
 */

package com.sdwulongshan.pass.reg.core.ex;
/**
 * 此异常为本项目IO异常的包装类，请参阅相关文档
 * @author Mango.
 * @since JDK 10
 * @version 1.0.2
 *
 */
public class InputAndOutPutException extends BaseException {

	
	private static final long serialVersionUID = -5882050011683325491L;

	public InputAndOutPutException() {
		
	}

	public InputAndOutPutException(String message) {
		super(message);
		
	}

	public InputAndOutPutException(Throwable cause) {
		super(cause);
		
	}

	public InputAndOutPutException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InputAndOutPutException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		

}

}