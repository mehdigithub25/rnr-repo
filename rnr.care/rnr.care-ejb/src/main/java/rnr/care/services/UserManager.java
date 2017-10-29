package rnr.care.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Member;
import rnr.care.entities.User;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
@LocalBean
@WebService(name = "rnrPortype", portName = "rnrPort", serviceName = "UserService", targetNamespace = "http://rnranimal.tn", endpointInterface = "rnr.care.services.UserManagerRemote")
public class UserManager implements UserManagerRemote, UserManagerLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManager() {
	}

	@WebMethod
	@WebResult()
	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@WebMethod
	@WebResult()
	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@WebMethod
	@WebResult
	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@WebMethod
	@WebResult
	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@WebMethod
	@WebResult
	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@WebMethod
	@WebResult
	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@WebMethod
	@WebResult
	@Override
	public User findUserByPseudo(String pseudo) {

		String jpql = "SELECT u FROM User  WHERE u.userName like '" + pseudo + "'";
		Query query = entityManager.createQuery(jpql);

		return (User) query.getSingleResult();
		// return (User) query.getResultList().get(0);

		// Query q = entityManager.createQuery();
		// q.setParameter("x", pseudo);
		// return (User) q.getResultList().get(0);
	}
	// ***************************//
	// JPAQuery query = new JPAQuery(entityManager);
	// User user = query.from(user)
	// .where(
	// user.userName.eq(pseudo) ;
	// return user ;

	// ************************************///
	// entityManager.createQuery(CriteriaQuery<T>);
	// Criteria criteria = createEntityCriteria();
	// criteria.add(Restrictions.eq("login", pseudo));
	@WebMethod
	@WebResult
	@Override
	public Member findMemberByPseudo(String pseudo) {

		String jpql = "SELECT u FROM u  WHERE u.userName like '" + pseudo + "'";
		Query query = entityManager.createQuery(jpql);

		return (Member) query.getSingleResult();
	}

	@WebMethod
	@WebResult
	@Override
	public List<User> findAllMember(String preudo) {
		String jpql = "SELECT u FROM User u where '" + preudo + "'";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findbylogin(String userName, String password) {
		Query query = entityManager.createQuery("select e from User e where e.userName=:l and e.password=:p");
		query.setParameter("l", userName).setParameter("p", password);
		
		return (User) query.getSingleResult();
	}
	
	@Override
	public List<Member> findAllVolunteer() {
		Query query = entityManager.createQuery("select e from Member e where e.volunteer=:l ");
		query.setParameter("l", true);
		
		return query.getResultList();
	}
	
	
	
	

	    

}
