package com.nt.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.dto.ResponseDTO;

@RestControllerAdvice
public class IPLTeamGlobalExceptionHandler {
	
	@ExceptionHandler(TeamNotFoundException.class)
	public ResponseEntity<ResponseDTO> teamNotFoundException(TeamNotFoundException exception) {
	
		return new ResponseEntity<ResponseDTO>(ResponseDTO.builder()
				.errorMessage(exception.getMessage())
				.statusCode("BAD REQUEST")
				.timstamp(LocalDateTime.now())
				.build(),
				HttpStatus.BAD_REQUEST);
	}

}
