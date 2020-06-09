package mx.com.example.demo.DAO;
import java.util.List;
import mx.com.example.demo.models.Cursa;

public interface ICursa {
	
	public List<Cursa> consultar();
	public Cursa buscarPorID(int id);
	public Cursa crear (Cursa cursa);
	public void actualizar (Cursa cursa);
	public void eliminar (int id);

}
