package mx.com.example.demo.DAO;
import java.util.List;
import mx.com.example.demo.models.Imparte;

public interface IImparte {
	
	public List<Imparte> consultar();
	public Imparte buscarPorID(int id);
	public Imparte crear (Imparte imparte);
	public void actualizar (Imparte imparte);
	public void eliminar (int id);

}
