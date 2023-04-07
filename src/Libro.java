import java.util.Date;

public class Libro {

	private String titulo,tematica,autor,isbn;
	private int id,numPaginas,stock;
	private String fechaPublicacion;

	public Libro(int id,String titulo,String tematica, String autor,
			String isbn,int numPaginas,String fecha, int stock) {
		this.id=id;
		this.titulo=titulo;
		this.tematica=tematica;
		this.autor=autor;
		this.isbn=isbn;
		this.numPaginas=numPaginas;
		this.fechaPublicacion=fecha;
		this.stock=stock;
	}
	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return "Libro: [ID= "+this.getId()+ " Titulo= "+this.getTitulo()+" - Tematica= "+this.tematica+
				" - Autor= "+this.getAutor()+" - ISBN= "+this.isbn+" - NumPAginas= "+this.numPaginas+
				" - Fecha Publicacion= "+this.getFechaPublicacion()+" - Stock= "+this.stock+"]";
	}

}
