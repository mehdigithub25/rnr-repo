package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import rnr.care.entities.Claim;
import rnr.care.entities.User;
import rnr.care.services.ClaimManagerRemote;
import rnr.care.services.UserManagerLocal;

@ManagedBean
@ViewScoped
public class UserBean {

	private User user = new User();
	private boolean showUsersList = false;
	private List<User> users = new ArrayList<>();

	@EJB
	private UserManagerLocal userManagerLocal;

	@EJB
	private ClaimManagerRemote claimManagerRemote;

	@PostConstruct
	private void init() {
		users = listMemberByRegionClaim();
	}

	public List<User> listMemberByRegionClaim() {

		List<User> memberByRegion = new ArrayList<>();

		List<Claim> AllClaims = new ArrayList<>();

		List<User> AllMember = new ArrayList<>();

		AllClaims = claimManagerRemote.findAllClaims();

		AllMember = userManagerLocal.findAllUsers();

		for (int j = 0; j < AllMember.size(); j++) {
			for (int i = 0; i < AllClaims.size(); i++) {

				if (AllClaims.get(i).getRegion().equals(AllMember.get(j).getRegion())) {
					memberByRegion.add(AllMember.get(j));

				}

			}

		}

		System.out.println("0000000" + memberByRegion);
		return memberByRegion;
	}

	public void doShowUsersList() {
		users = listMemberByRegionClaim();
		showUsersList = true;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isShowUsersList() {
		return showUsersList;
	}

	public void setShowUsersList(boolean showUsersList) {
		this.showUsersList = showUsersList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
