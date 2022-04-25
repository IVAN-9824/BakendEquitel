package ms.equitel.bd.modelo;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "motor")
public class Motor {
	@Id
	private String ref;
	private String potencia;
	private String descripcion;
	private BigInteger valorImportacion;
	
	public Motor() {
		
	}

	public Motor(String ref, String potencia, String descripcion, BigInteger valorImportacion) {
		super();
		this.ref = ref;
		this.potencia = potencia;
		this.descripcion = descripcion;
		this.valorImportacion = valorImportacion;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigInteger getValorImportacion() {
		return valorImportacion;
	}

	public void setValorImportacion(BigInteger valorImportacion) {
		this.valorImportacion = valorImportacion;
	}

	
	

}
