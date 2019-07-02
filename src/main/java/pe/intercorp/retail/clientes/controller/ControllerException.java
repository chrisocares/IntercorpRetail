package pe.intercorp.retail.clientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;
import pe.intercorp.retail.clientes.util.Constantes;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<?> handleExceptions(RuntimeException exa) {
		MessageResponseCustomerDto messageResponseCustomerDto = new MessageResponseCustomerDto();
		messageResponseCustomerDto.setResponseCode(Constantes.CODE_BAD_REQUEST);
		messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_BADREQUEST);
		return new ResponseEntity<>(messageResponseCustomerDto, HttpStatus.OK);
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<?> handleExceptions2(MethodArgumentNotValidException exa) {
		MessageResponseCustomerDto messageResponseCustomerDto = new MessageResponseCustomerDto();
		messageResponseCustomerDto.setResponseCode(Constantes.CODE_BAD_REQUEST);
		messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_BADREQUEST);
		return new ResponseEntity<>(messageResponseCustomerDto, HttpStatus.OK);
	}

}
