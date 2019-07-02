package pe.intercorp.retail.clientes.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import pe.intercorp.retail.clientes.dto.MessageResponseCustomerDto;
import pe.intercorp.retail.clientes.service.implement.CustomerServiceImplement;
import pe.intercorp.retail.clientes.util.Constantes;



public class CustomerServiceImplementTest {
	
	@Test
	public void buildMessageSuccesfulTest() {
		MessageResponseCustomerDto messageResponseCustomerDto = new MessageResponseCustomerDto();
		messageResponseCustomerDto.setResponseCode(Constantes.CODE_SUCCESFULL);
		messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_SUCCESFULL);
		CustomerServiceImplement customerServiceImplement = new CustomerServiceImplement();
		assertThat(messageResponseCustomerDto).isEqualToComparingFieldByField(customerServiceImplement.buildMessage(true));
	}
	
	@Test
	public void buildMessageFailTest() {
		MessageResponseCustomerDto messageResponseCustomerDto = new MessageResponseCustomerDto();
		messageResponseCustomerDto.setResponseCode(Constantes.CODE_FAILED);
		messageResponseCustomerDto.setResponseMessage(Constantes.MESSAGE_FAILED);
		CustomerServiceImplement customerServiceImplement = new CustomerServiceImplement();
		assertThat(messageResponseCustomerDto).isEqualToComparingFieldByField(customerServiceImplement.buildMessage(false));
	}
}
