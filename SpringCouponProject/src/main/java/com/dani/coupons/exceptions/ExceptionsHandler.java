package com.dani.coupons.exceptions;

//import javax.ws.rs.core.Response;
//import `.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//import com.dani.coupons.beans.ErrorBean;
//
//@Provider
//public class ExceptionsHandler implements ExceptionMapper<Throwable> 
//{
//	@Override
//	public Response toResponse(Throwable exception) 
//	{
//		exception.printStackTrace();
//		if (exception instanceof ApplicationException){
//			ApplicationException e = (ApplicationException) exception;
//			int internalErrorCode = e.getErrorType().getInternalErrorCode();
//			String internalMessage = e.getMessage();									
//			String externalMessage = "Error"; //e.getErrorType().getInternalMessage();									
//			ErrorBean errorBean = new ErrorBean(internalErrorCode, internalMessage, externalMessage);
//			return Response.status(internalErrorCode).entity(errorBean).build();
//		}
//		else if(exception instanceof Exception) {
//			String internalMessage = exception.getMessage();
//			ErrorBean errorBean = new ErrorBean(601, internalMessage, "General error");
//			return Response.status(601).entity(errorBean).build();
//		}
//		return Response.status(500).entity(null).build();
//	}
//}
