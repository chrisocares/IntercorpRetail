package pe.intercorp.retail.clientes.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MicroserviceUtil {

	public static String generateTransactionID() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constantes.DATE_DDMMYYYYHHMMSS);
		return  Constantes.INTERBANKCUSTOMER
				.concat(LocalDateTime.now().format(dateTimeFormatter))
				.concat(String.valueOf(Instant.now().getEpochSecond()));
	}
}
