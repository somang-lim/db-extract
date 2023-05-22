package com.vtw.error;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandlingController implements ErrorController {

	private final String ERROR_PAGE_PATH = "/error/error";
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			int statusCode = Integer.valueOf(status.toString());
			
			// 400 ERROR
			if(statusCode == HttpStatus.BAD_REQUEST.value()) {
				codeStatus(request, model);
				
				return ERROR_PAGE_PATH;
			}
			
			// 403 ERROR
			if(statusCode == HttpStatus.FORBIDDEN.value()) {
				codeStatus(request, model);
				
				return ERROR_PAGE_PATH;
			}
			
			// 404 ERROR
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				codeStatus(request, model);
				
				return ERROR_PAGE_PATH;
			}
			
			// 405 ERROR
			if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
				codeStatus(request, model);
				
				return ERROR_PAGE_PATH;
			}
			
			// 500 ERROR
			if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				codeStatus(request, model);
				
				return ERROR_PAGE_PATH;
			}
		}
		
		return ERROR_PAGE_PATH;
		
	}
	
		private void codeStatus(HttpServletRequest request, Model model) {
			Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
			HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
			
			model.addAttribute("code", status.toString());
			model.addAttribute("msg", httpStatus.getReasonPhrase());
			model.addAttribute("timestamp", new Date());
		}
}
