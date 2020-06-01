package Reinscripciones.DAO;

import java.util.List;

import Reinscripciones.models.horarios;

public interface HorarioDAO {

	List<horarios> consultar();

	void eliminar(int idhorario);

	void actualizar(horarios hora);

}
