package pe.intercorp.retail.clientes.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import pe.intercorp.retail.clientes.dto.CustomerDto;
import pe.intercorp.retail.clientes.dto.CustomerModel;

public class MicroserviceUtil {

	private MicroserviceUtil() { throw new IllegalStateException("Utility class"); }
	
	public static String generateTransactionID() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constantes.DATE_DDMMYYYYHHMMSS);
		return  Constantes.INTERCORPCUSTOMER
				.concat(LocalDateTime.now().format(dateTimeFormatter))
				.concat(String.valueOf(Instant.now().getEpochSecond()));
	}
	
	public static CustomerModel deserealizeDTO(CustomerDto customer) {
		CustomerModel customerModel = new CustomerModel();
		customerModel.setApellido(customer.getApellido());
		customerModel.setEdad(customer.getEdad());
		customerModel.setFechaNacimiento(customer.getFechaNacimiento());
		customerModel.setNombre(customer.getNombre());
		customerModel.setFechaMuerte(MicroserviceUtil.generateDateOfDeath(customer.getFechaNacimiento()));
		return customerModel;
	}
	
	public static Date generateDateOfDeath(Date birthDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		int averageLifeMax = 80;
		int averageLifeMin = 34;
		int randomYearsPerson = new Random().nextInt((averageLifeMax - averageLifeMin) + 1) + averageLifeMin;
		int yearDeath = calendar.get(Calendar.YEAR) + randomYearsPerson;
		int monthDeath = new Random().nextInt((12)) + 1;
		YearMonth yearMonth = YearMonth.of(yearDeath, monthDeath);
		int daysInMonth = yearMonth.lengthOfMonth();
		return new GregorianCalendar(yearDeath,monthDeath,daysInMonth).getTime();
	}
}
