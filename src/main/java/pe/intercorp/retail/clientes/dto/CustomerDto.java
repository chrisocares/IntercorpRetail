package pe.intercorp.retail.clientes.dto;

import java.sql.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class CustomerDto {

	@NotNull @NotEmpty @Valid
	@JsonProperty(required = true)
	private String nombre;
	@NotNull @NotEmpty @Valid
	@JsonProperty(required = true)
	private String apellido;
	@JsonProperty(required = true)
	private Integer edad;
	@JsonProperty(required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
}