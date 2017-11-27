package rnr.care.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.Event;
import rnr.care.entities.Participation;
import rnr.care.entities.User;

@WebService
@Remote
public interface ParticipationManagementRemote {
	@WebMethod(operationName = "add")
	@WebResult()
	public void saveOrUpdateParticipation(@WebParam(name = "int")int number,@WebParam(name = "date") Date d ,@WebParam(name = "event") Event e,@WebParam(name = "user")User u);

	/*@WebMethod(operationName = "cancelParticipationById")
	@WebResult()
	void cancelParticipationById(@WebParam(name = "participation") Participation p);

	@WebMethod(operationName = "cancelParticipationByEvent")
	@WebResult(name = "participation")
	public Participation findParticipationByEvent(int id, int iduser);*/

	@WebMethod(operationName = "FindAll")
	@WebResult(name = "participationList")
	List<Participation> findAllParticicpations();
	
}
