package by.nc.school.dev.web;

import java.util.ArrayList;
import java.util.List;

import by.nc.school.dev.entity.*;
import by.nc.school.dev.repository.SemesterRepository;
import by.nc.school.dev.repository.SubjectRepository;
import by.nc.school.dev.repository.WorkPlanRepository;
import by.nc.school.dev.services.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import by.nc.school.dev.repository.AppUserRepository;

/**
 * Rest controller for authentication and user details. All the web services of
 * this rest controller will be only accessible for ADMIN users only
 */
@RestController
@RequestMapping(value = "/api")
public class AppUserRestController {
	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private WorkPlanRepository workPlanRepository;

	@Autowired
	private SemesterRepository semesterRepository;

	/**
	 * Web service for getting all the appUsers in the application.
	 * 
	 * @return list of all AppUser
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<AppUser> users() {
		return appUserRepository.findAll();
	}

	/**
	 * Web service for getting a user by his ID
	 * 
	 * @param id
	 *            appUser ID
	 * @return appUser
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<AppUser> userById(@PathVariable Long id) {
		AppUser appUser = appUserRepository.findOne(id);
		if (appUser == null) {
			return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
		}
	}

	/**
	 * Method for deleting a user by his ID
	 * 
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AppUser> deleteUser(@PathVariable Long id) {
		AppUser appUser = appUserRepository.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		if (appUser == null) {
			return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
		} else if (appUser.getUsername().equalsIgnoreCase(loggedUsername)) {
			throw new RuntimeException("You cannot delete your account");
		} else {
			appUserRepository.delete(appUser);
			return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
		}

	}

	/**
	 * Method for adding a appUser
	 * 
	 * @param appUser
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
		if (appUserRepository.findOneByUsername(appUser.getUsername()) != null) {
			throw new RuntimeException("Username already exist");
		}
		//appUser.setGroup(new Group()); TODO
		return new ResponseEntity<AppUser>(appUserRepository.save(appUser), HttpStatus.CREATED);
	}

	/**
	 * Method for editing an user details
	 * 
	 * @param appUser
	 * @return modified appUser
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public AppUser updateUser(@RequestBody AppUser appUser) {
		if (appUserRepository.findOneByUsername(appUser.getUsername()) != null
				&& appUserRepository.findOneByUsername(appUser.getUsername()).getId() != appUser.getId()) {
			throw new RuntimeException("Username already exist");
		}
		return appUserRepository.save(appUser);
	}

	/**
	 * Method for create subject
	 *
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/create-subject", method = RequestMethod.GET)
	public List<Subject> subjects() {
		return subjectRepository.findAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/create-subject", method = RequestMethod.PUT)
	public void createSubject(@RequestBody Subject subject) {
		List<Subject> array = subjectRepository.findAllByName(subject.getName());
		if(array.size() == 0){
			subjectRepository.save(subject);
		}

	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@RequestMapping(value = "/add-mark", method = RequestMethod.GET)
//	public List<WorkPlan> workPlans() {
//		System.out.println("1");
//		return workPlanRepository.findAll();
//	}
//
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@RequestMapping(value = "/add-mark", method = RequestMethod.PUT)
//	public void addMark(@RequestBody WorkPlan workPlan) {
//		System.out.println("2");
////		List<Subject> array = subjectRepository.findAllByName(subject.getName());
////		if(array.size() == 0){
////			subjectRepository.save(subject);
////		}
//		workPlanRepository.save(workPlan);
//
//	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/add-workplan", method = RequestMethod.GET)
	public List<WorkPlan> workPlans() {
		return workPlanRepository.findAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/add-workplan", method = RequestMethod.PUT)
	public void createSubject1(@RequestBody WorkPlanModel workPlanModel) {
//		List<Subject> array = subjectRepository.findAllByName(subject.getName());
//		if(array.size() == 0){
//			subjectRepository.save(subject);
//		}
		Subject s = subjectRepository.findOneByName(workPlanModel.getSubjectName());
		Semester sem = semesterRepository.findOneBySemesterNumber(Integer.parseInt(workPlanModel.getSemesterNumber()));
		AppUser user = appUserRepository.findOneByUsername(workPlanModel.getAppUserUserName());
		if(s!=null && sem!=null && user!=null && CheckService.checkForTeacherRole(user)){
			WorkPlan workPlan = new WorkPlan(s,sem,user);
			workPlanRepository.save(workPlan);

		}
	}
	@RequestMapping(value = "/workplans", method = RequestMethod.GET)
	public List<WorkPlan> workPlans1() {
		return workPlanRepository.findAll();
	}
}
