package br.com.desafiovalemobi.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.desafiovalemobi.model.Mercadoria;

public class MercadoriaDAO implements DAO{
	private static MercadoriaDAO instance;
	protected EntityManager entityManager;

	public static MercadoriaDAO getInstance() {
		if (instance == null) {
			instance = new MercadoriaDAO();
		}

		return instance;
	}

	public MercadoriaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DAO.BANCO);
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@Override
	public boolean insert(Mercadoria mercadoria) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(mercadoria);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean delete(Mercadoria mercadoria) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(
					entityManager.contains(mercadoria) ? mercadoria : entityManager.merge(mercadoria));
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean update(Mercadoria mercadoria) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(mercadoria);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public Mercadoria selectById(long id) {
		return entityManager.find(Mercadoria.class, id);
	}

	@Override
	public List<Mercadoria> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Mercadoria> selectAll() {
		return entityManager.createQuery("FROM " + Mercadoria.class.getName()).getResultList();
	}

}
