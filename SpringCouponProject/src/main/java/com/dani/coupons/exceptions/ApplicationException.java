package com.dani.coupons.exceptions;


	import com.dani.coupons.Enums.ErrorType;

	public class ApplicationException  extends Exception{

		private ErrorType errorType;

		// use when we are the ones who initiate the exception
		public ApplicationException(ErrorType errorType, String message) {
			super(message);
			this.errorType = errorType;
		}

		public ApplicationException(ErrorType errorType, String message, Exception e) {
			super(message, e);
			this.errorType = errorType;
		}

		public ErrorType getErrorType() {
			return errorType;
		}

	}


