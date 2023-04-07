package proyectoMiguelDAM;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tests {

	public static void main(String[] args) {
		String fechaString = "2023-03-26";
		DateFormat formato = new DateOf("YYYY-mm-dd");
		try {
			Date fechaDate = formato.parse(fechaString);
			System.out.println(fechaDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
