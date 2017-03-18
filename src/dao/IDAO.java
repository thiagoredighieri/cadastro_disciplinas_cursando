package dao;

import java.util.List;

public interface IDAO<Entity> {

		public abstract int salvar(Entity objeto);
		
		public abstract boolean excluir(Entity objeto);
		
		public abstract List<Entity> listar();
		
		public abstract Entity buscarPorNome(String nome);
}
