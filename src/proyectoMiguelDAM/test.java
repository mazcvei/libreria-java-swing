package proyectoMiguelDAM;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) {
		String cadena = "12a aaa";
		String formatoFecha = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setLenient(false);
		try {
			sdf.parse("2023-01-0fghg1"); // Intentar analizar la fecha
			System.out.println(true); // Si no hay excepci�n, la fecha es v�lida
		} catch (ParseException e) {
			System.out.println(false); // Si hay excepci�n, la fecha es inv�lida
		}

	}

}
