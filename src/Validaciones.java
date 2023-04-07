import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validaciones {

	public static boolean validarFecha(String fecha) {
		String formatoFecha = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setLenient(false); // la fecha será validada de manera estricta y cualquier valor fuera del rango válido será rechazado
		try {
			sdf.parse(fecha); // Intentar analizar la fecha
			return true; // Si no hay excepción, la fecha es válida
		} catch (ParseException e) {
			return false; // Si hay excepción, la fecha es inválida
		}
	}


	public static boolean validarString(String cadena) {
		if(cadena.isEmpty() || cadena.length()<1) {
			return false;
		}
		return cadena.matches("^[\\p{L}\\p{N}\\sáéíóúÁÉÍÓÚñÑ]+$");
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
