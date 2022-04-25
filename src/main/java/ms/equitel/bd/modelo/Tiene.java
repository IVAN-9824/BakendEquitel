package ms.equitel.bd.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tener")
public class Tiene {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id ;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name ="id_motor")
	private Motor motor;
	@ManyToOne
	@JoinColumn(name ="id_parte")
	private Parte parte;
	
	public Tiene () {
		
	}
	public Tiene(int id, int cantidad, Motor motor, Parte parte) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.motor = motor;
		this.parte = parte;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	
	
}
