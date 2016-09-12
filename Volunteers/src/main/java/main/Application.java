package main;

import java.io.IOException;
import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Administrator;
import model.Project;
import model.UserServices;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Calling administrator services
		Administrator admin = new Administrator(sessionFactory);
		admin.createProject();
		//updating the project status
		admin.updateProjectStatus();
		//updating the task status
		admin.updateProjectTaskStatus();
		// admin.updateProjectStatus();

		// Calling the User services
		UserServices service = new UserServices(sessionFactory);
		//list of tasks for the given project
		service.listTaskofProject();
		// list of tasks of project with beneficiaries
		service.projectInfowithBeneficiaries();
		//list of project with particular resource skill
		service.projectwithParticularResource("Java Developers");
		
		
	}

}
