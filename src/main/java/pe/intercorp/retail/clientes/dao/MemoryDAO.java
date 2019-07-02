package pe.intercorp.retail.clientes.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import pe.intercorp.retail.clientes.dto.CustomerModel;
import pe.intercorp.retail.clientes.util.Constantes;

public class MemoryDAO {

	private static final Log logger = LogFactory.getLog(MemoryDAO.class);
	
	/**
	 * Write in file JSON for persist data
	 * @param customer
	 */
	public static void writePersistMemoryCustomer(CustomerModel customer) {
		
		try {
			File fileJson = new File(Constantes.PATH_JSON);
			String jsonContent = new String(Files.readAllBytes(fileJson.toPath()), Charset.forName(StandardCharsets.UTF_8.name()));
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			List<CustomerModel> customerList = objectMapper.readValue(jsonContent, typeFactory.constructCollectionType(List.class, CustomerModel.class));
			customerList.add(customer);
			FileWriter fileJSONCustomer = new FileWriter(fileJson, false);
			fileJSONCustomer.write(objectMapper.writeValueAsString(customerList));
			fileJSONCustomer.close();
		} catch (IOException e) {
			logger.error("ERROR {} " + e.getMessage());
		}
	}
	
	/**
	 * When the application starts , first read all the data in the JSON file with a bean. 
	 * @param customerList
	 * @return List<CustomerModel>
	 */
	public static List<CustomerModel> recoverPersistMemoryCustomer(List<CustomerModel> customerList) {
		try {
			File fileJson = new File(Constantes.PATH_JSON);
			String jsonContent = new String(Files.readAllBytes(fileJson.toPath()), Charset.forName(StandardCharsets.UTF_8.name()));
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			customerList = objectMapper.readValue(jsonContent, typeFactory.constructCollectionType(List.class, CustomerModel.class));			
		} catch (IOException e) {
			logger.error("ERROR {} " + e.getMessage());
		}
		return customerList;
	}
}
