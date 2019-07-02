package pe.intercorp.retail.clientes.service;

import java.util.List;

import pe.intercorp.retail.clientes.dto.CustomerDto;
import pe.intercorp.retail.clientes.dto.CustomerModel;
import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;

public interface CustomerService {

	/**
	 * Add a new customer
	 **/
	public MessageResponseCustomerDto createCustomer(CustomerDto customer);
	
	/**
	 * Get all the customers and add the date of death
	 * @return List<CustomerModel>
	 */
	public List<CustomerModel> getCustomers();
}
