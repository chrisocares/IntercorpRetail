package pe.intercorp.retail.clientes.util;

public class Constantes {

	public static final String DATE_DDMMYYYYHHMMSS = "ddMMyyyyHHmmss";
	public static final String INTERCORPCUSTOMER = "INTERCORP_CUSTOMER-";
	public static final String MESSAGEID = "messageId";
	public static final String CODE_BAD_REQUEST = "400";
	public static final String CODE_SUCCESFULL = "200";
	public static final String CODE_FAILED = "-1";
	public static final String MESSAGE_BADREQUEST = "Request invalido, verifique los campos.";
	public static final String MESSAGE_SUCCESFULL = "El cliente se creo exitosamente.";
	public static final String MESSAGE_FAILED = "Ocurrio un error al procesar el mensaje. Intentelo dentro de un momento.";
	public static final String PATH_JSON = "D:\\home\\site\\wwwroot\\memoryCustomer.json";
	
	protected Constantes() {
		throw new IllegalAccessError("Clase Constantes");
	}
}
