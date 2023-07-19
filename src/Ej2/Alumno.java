package Ej2;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private boolean aprobado;
	
	private double calculaMedia() {
		media=(this.nota1+this.nota2+this.nota3)/3;
		return media;
	}
	
	private boolean aprobar() {
		return this.media>=5;
	}
	
	public Alumno(String nombre, double nota1, double nota2, double nota3) {
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public Alumno() {
		this.nombre = "";
		this.nota1 = 0;
		this.nota2 = 0;
		this.nota3 = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getMedia() {
		return media=calculaMedia();
	}

	public boolean isAprobado() {
		return aprobado=aprobar();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\nnota1: " + nota1 + "\nnota2: " + nota2 + "\nnota3: " + nota3 + "\nmedia: "
				+ media;
	}
	
	
}
