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
 * 此异常为AES相关操作产生的异常，如果要知道异常详情，请参阅JavaAPI
 * @author Mango.
 * @version 1.0.2
 * @since JDK 11
 */
public class AESException extends BaseException {

	
	private static final long serialVersionUID = -8586781839440466918L;

	public AESException() {
		
	}

	public AESException(String message) {
		super(message);
		
	}

	public AESException(Throwable cause) {
		super(cause);
		
	}

	public AESException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AESException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
