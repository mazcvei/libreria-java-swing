import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validaciones {

	public static boolean validarFecha(String fecha) {
		String formatoFecha = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setLenient(false); // la fecha ser� validada de manera estricta y cualquier valor fuera del rango v�lido ser� rechazado
		try {
			sdf.parse(fecha); // Intentar analizar la fecha
			return true; // Si no hay excepci�n, la fecha es v�lida
		} catch (ParseException e) {
			return false; // Si hay excepci�n, la fecha es inv�lida
		}
	}


	public static boolean validarString(String cadena) {
		if(cadena.isEmpty() || cadena.length()<1) {
			return false;
		}
		return cadena.matches("^[\\p{L}\\p{N}\\s������������]+$");
	}
	public static boolean validarInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


}
