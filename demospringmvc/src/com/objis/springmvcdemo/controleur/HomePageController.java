package com.objis.springmvcdemo.controleur;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.objis.springmvcdemo.domaine.Employe;
import com.objis.springmvcdemo.service.EmployeManager;

public class HomePageController extends AbstractController {
	/*
	 * INJECTION Spring d'un bean Service dans le controleur. 
	 * Le bean Service est configur� dans objisapp-service.xml
	 */
	private EmployeManager employeManager;

	public void setEmployeManager(EmployeManager employeManager) {
		this.employeManager = employeManager;
	}
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Lancement du Service et r�cup�ration donn�es en base
		 */
		List<Employe> listeEmployes = employeManager.getAllEmployes();

		/*
		 * Envoi Vue + Mod�le MVC pour Affichage donn�es vue
		 */
		return new ModelAndView("home", "employes", listeEmployes);
	}
}
