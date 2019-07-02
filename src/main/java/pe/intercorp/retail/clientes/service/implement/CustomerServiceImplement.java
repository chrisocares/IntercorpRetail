package pe.intercorp.retail.clientes.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.intercorp.retail.clientes.dao.MemoryDAO;
import pe.intercorp.retail.clientes.dto.CustomerDto;
import pe.intercorp.retail.clientes.dto.CustomerModel;
import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;
import pe.intercorp.retail.clientes.service.CustomerService;
import pe.intercorp.retail.clientes.util.Constantes;
import pe.intercorp.retail.clientes.util.MicroserviceUtil;

@Service
public class CustomerServiceImplement implements CustomerService {

	/**
	 * @author Ocares Hermosa Christopher
	 *
	 */
	
	@Autowired
	@Qualifier("customerMemory")
	private List<CustomerModel> customerMemory; 
	
	@Override
	public MessageResponseCustomerDto createCustomer(CustomerDto customer) {
		CustomerModel customerModel = MicroserviceUtil.deserealizeDTO(customer);
		customerMemory.add(customerModel);
		MessageResponseCustomerDto messageResponse = customerMemory.contains(customerModel) ? buildMessage(true) : buildMessage(false);
		MemoryDAO.writePersistMemoryCustomer(customerModel);
		return messageResponse;
	}
	
	public MessageResponseCustomerDto buildMessage(boolean isSuccesful) {
		MessageResponseCustomerDto messageResponseCustomerDto = new MessageResponseCustomerDto();
		if (isSuccesful) {
			messageResponseCustomerDto.setResponseCode(Constantes.CODE_SUCCESFULL);
			messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_SUCCESFULL);
		} else {
			messageResponseCustomerDto.setResponseCode(Constantes.CODE_FAILED);
			messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_FAILED);
		}
		return messageResponseCustomerDto;
	}

	@Override
	public List<CustomerModel> getCustomers() {
		return customerMemory;
	}
}
