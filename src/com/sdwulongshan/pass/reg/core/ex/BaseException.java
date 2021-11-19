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
 * 此项目所有异常的基类，一般，不直接向外抛出该异常
 * @author Mango.
 * @since JDK 11
 * @version 1.0.2
 *
 */
public class BaseException extends RuntimeException {

	
	private static final long serialVersionUID = -5396483201307088515L;

	public BaseException() {
		
	}

	public BaseException(String message) {
		super(message);
		
	}

	public BaseException(Throwable cause) {
		super(cause);
		
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
