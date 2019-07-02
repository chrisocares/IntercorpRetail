package pe.intercorp.retail.clientes.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.intercorp.retail.clientes.dao.MemoryDAO;
import pe.intercorp.retail.clientes.dto.CustomerModel;

@Configuration
public class AppConfig {

	/**
	 * @author Ocares Hermosa Christopher
	 *
	 */
	
	private static final Log logger = LogFactory.getLog(AppConfig.class);
	
	@Bean
	@Qualifier("customerMemory")
	public List<CustomerModel> beanCustomers(){
		List<CustomerModel> listCustomers = new ArrayList<>();
		logger.info("Cargando clientes desde JSON ...");
		listCustomers = MemoryDAO.recoverPersistMemoryCustomer(listCustomers);
		logger.info("Se restauraron los clientes exitosamente");
		return  listCustomers;
	}
}
