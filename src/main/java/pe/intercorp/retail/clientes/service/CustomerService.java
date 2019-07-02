package pe.intercorp.retail.clientes.service;

import pe.intercorp.retail.clientes.dto.CustomerDto;
import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;

public interface CustomerService {

	/**
	 * Add a new customer
	 **/
	public MessageResponseCustomerDto createCustomer(CustomerDto customer);
}
