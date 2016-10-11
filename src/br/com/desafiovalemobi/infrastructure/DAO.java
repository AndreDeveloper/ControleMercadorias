package br.com.desafiovalemobi.infrastructure;

import java.util.List;

import br.com.desafiovalemobi.model.Mercadoria;

public interface DAO {
	public static final String BANCO = "BANCO";
	public boolean insert(Mercadoria mercadoria);
	public boolean delete(Mercadoria mercadoria);
	public boolean update(Mercadoria mercadoria);
	public Mercadoria selectById(long id);
	public List<Mercadoria> selectByName(String name);
	public List<Mercadoria> selectAll();
}
