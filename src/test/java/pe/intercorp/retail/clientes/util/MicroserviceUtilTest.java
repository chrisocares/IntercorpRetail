package pe.intercorp.retail.clientes.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import pe.intercorp.retail.clientes.dto.CustomerDto;

public class MicroserviceUtilTest {

	@Test
	public void generateTransactionIDTest() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constantes.DATE_DDMMYYYYHHMMSS);
		String transactionID = Constantes.INTERCORPCUSTOMER
				.concat(LocalDateTime.now().format(dateTimeFormatter))
				.concat(String.valueOf(Instant.now().getEpochSecond()));
		assertThat(transactionID).isEqualTo(MicroserviceUtil.generateTransactionID());
	}
	
	@Test
	public void deserealizeDTOTest() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setEdad(Mockito.anyInt());
		customerDto.setApellido(Mockito.anyString());
		customerDto.setNombre(Mockito.anyString());
		customerDto.setFechaNacimiento(new Date());
		assertNotNull(MicroserviceUtil.deserealizeDTO(customerDto));
	}

}