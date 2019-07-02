package pe.intercorp.retail.clientes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.intercorp.retail.clientes.dto.CustomerDto;
import pe.intercorp.retail.clientes.dto.CustomerModel;
import pe.intercorp.retail.clientes.dto.KPICustomerDto;
import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;
import pe.intercorp.retail.clientes.service.CustomerService;
import pe.intercorp.retail.clientes.util.Constantes;
import pe.intercorp.retail.clientes.util.MicroserviceUtil;

@RestController
public class CustomerController {

	/**
	 * @author Ocares Hermosa Christopher
	 *
	 */
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<MessageResponseCustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {
		MessageResponseCustomerDto messageResponse = customerService.createCustomer(customer);
		String messageId = MicroserviceUtil.generateTransactionID();
		return ResponseEntity.status(HttpStatus.OK).header(Constantes.MESSAGEID, messageId).body(messageResponse);
	}
	
	@GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<List<CustomerModel>> getCustomers(){
		List<CustomerModel> customerList = customerService.getCustomers();
		String messageId = MicroserviceUtil.generateTransactionID();
		return ResponseEntity.status(HttpStatus.OK).header(Constantes.MESSAGEID, messageId).body(customerList);
	}
	
	@GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<KPICustomerDto> getkpiCustomers(){
		KPICustomerDto kpiCustomerDto = customerService.getKPICustomers();
		String messageId = MicroserviceUtil.generateTransactionID();
		return ResponseEntity.status(HttpStatus.OK).header(Constantes.MESSAGEID, messageId).body(kpiCustomerDto);
	}
}
