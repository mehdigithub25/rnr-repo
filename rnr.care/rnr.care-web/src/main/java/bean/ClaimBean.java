package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.BeanParam;

import rnr.care.entities.Claim;
import rnr.care.entities.Member;
import rnr.care.entities.User;
import rnr.care.services.ClaimManagerRemote;
import rnr.care.services.UserManagerLocal;

@ManagedBean
@ViewScoped
public class ClaimBean {

	@EJB
	private UserManagerLocal userManagerLocal;



	private boolean showClaimsList = false;
	private Claim claim = new Claim();
	
    
	//private Identify ident = new Identify() ;
	
	

	private List<Claim> claims = new ArrayList<>();
	
	

	
 //private int idUserConn = ident.getUser().getIdUser();





	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}


	@EJB
	private ClaimManagerRemote claimManagerRemote;

	@PostConstruct
	private void init() {

		setClaims(claimManagerRemote.findAllClaims());
	}

	public void doShowClaimssList() {
		setShowClaimsList(true);
	}

	public void doShowNewClaim() {
		claim = new Claim();
		setShowClaimsList(true);
	}

	public void doSaveOrUpdateClaim() {

		//idUsercon = userManagerLocal.getUserConnected().getIdUser();

		//claim.setIdMember(idUserConn);
		
		claimManagerRemote.addClaim(claim);

		//claim.setIdMember(idUserConn);
		
		//System.out.println("11111"+idUserConn);
		// setClaim(claim);
		setShowClaimsList(false);
		init();
		
		String body= claim.getBody();
		
		String title = claim.getTitle();
		
		claimManagerRemote.sendMessage("mehdi.benaissa1@esprit.tn", "macro7mito", "mehdi.benaissa26@gmail.com", title,
				body);
	}

	public boolean isShowClaimsList() {
		return showClaimsList;
	}

	public void setShowClaimsList(boolean showClaimsList) {
		this.showClaimsList = showClaimsList;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public String doListClaim() {
		String navigateTo = "";

		navigateTo = "/pages/member/ListClaims?faces-redirect=true";

		return navigateTo;
	}
	








}
