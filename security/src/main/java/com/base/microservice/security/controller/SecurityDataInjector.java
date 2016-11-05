package com.base.microservice.security.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.base.microservice.security.constants.MenuItemType;
import com.base.microservice.security.hibernate.dao.AuthorizationGroupDAO;
import com.base.microservice.security.hibernate.dao.UserAccountDAO;
import com.base.microservice.security.hibernate.domain.AuthorizationGroup;
import com.base.microservice.security.hibernate.domain.AuthorizationGroupMenuItem;
import com.base.microservice.security.hibernate.domain.MenuItem;
import com.base.microservice.security.hibernate.domain.MenuItemParameter;
import com.base.microservice.security.hibernate.domain.UserAccount;
import com.base.microservice.security.service.CryptoService;

@Controller
public class SecurityDataInjector implements CommandLineRunner {

	@Autowired
	private AuthorizationGroupDAO authorizationGroupDAO;

	@Autowired
	private UserAccountDAO userAccountDAO;

	@Autowired
	private CryptoService cryptoService;

	private void injectAuthorizationAdmin() {
		MenuItem menuItem1 = new MenuItem("Web", MenuItemType.SECTION.getValue());
		MenuItem menuItem2 = new MenuItem("Home", MenuItemType.WEBVIEW.getValue());
		MenuItem menuItem3 = new MenuItem("Facebook", MenuItemType.WEBVIEW.getValue());
		MenuItem menuItem4 = new MenuItem("App", MenuItemType.SECTION.getValue());
		MenuItem menuItem5 = new MenuItem("Pinterest app", MenuItemType.INTENT.getValue());

		menuItem2.setIconPath("https://s6.postimg.org/6p83pcrch/alarm_clock.png");
		menuItem5.setIconPath("https://s6.postimg.org/iiai7bd69/garbage_2.png");

		// 1 is section, no need to set param
		// 4 is section, no need to set param
		MenuItemParameter menuItemParameter2 = new MenuItemParameter();
		MenuItemParameter menuItemParameter3 = new MenuItemParameter();
		MenuItemParameter menuItemParameter5 = new MenuItemParameter();
		List<MenuItemParameter> parametersMenuItem2 = new ArrayList<>();
		List<MenuItemParameter> parametersMenuItem3 = new ArrayList<>();
		List<MenuItemParameter> parametersMenuItem5 = new ArrayList<>();

		parametersMenuItem2.add(menuItemParameter2);
		menuItem2.setParameters(parametersMenuItem2);
		menuItemParameter2.setValue("http://www.tawabocah.com");
		menuItemParameter2.setMenuItem(menuItem2);

		parametersMenuItem3.add(menuItemParameter3);
		menuItem3.setParameters(parametersMenuItem3);
		menuItemParameter3.setValue("http://facebook.com");
		menuItemParameter3.setMenuItem(menuItem3);

		parametersMenuItem5.add(menuItemParameter5);
		menuItem5.setParameters(parametersMenuItem5);
		menuItemParameter5.setValue("com.pinterest");
		menuItemParameter5.setMenuItem(menuItem5);

		AuthorizationGroup authorizationGroup = new AuthorizationGroup("Admin");
		Set<MenuItem> authorizedMenuItems = new HashSet<>();
		authorizedMenuItems.add(menuItem1);
		authorizedMenuItems.add(menuItem2);
		authorizedMenuItems.add(menuItem3);
		authorizedMenuItems.add(menuItem4);
		authorizedMenuItems.add(menuItem5);

		AuthorizationGroupMenuItem authorizationGroupMenuItem1 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem1.setMenuItem(menuItem1);
		authorizationGroupMenuItem1.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem1.setItemSequence(10);

		AuthorizationGroupMenuItem authorizationGroupMenuItem2 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem2.setMenuItem(menuItem2);
		authorizationGroupMenuItem2.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem2.setItemSequence(20);

		AuthorizationGroupMenuItem authorizationGroupMenuItem3 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem3.setMenuItem(menuItem3);
		authorizationGroupMenuItem3.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem3.setItemSequence(30);

		AuthorizationGroupMenuItem authorizationGroupMenuItem4 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem4.setMenuItem(menuItem4);
		authorizationGroupMenuItem4.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem4.setItemSequence(40);

		AuthorizationGroupMenuItem authorizationGroupMenuItem5 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem5.setMenuItem(menuItem5);
		authorizationGroupMenuItem5.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem5.setItemSequence(50);

		Set<AuthorizationGroupMenuItem> authorizationGroupMenuItems = new TreeSet<>();
		authorizationGroupMenuItems.add(authorizationGroupMenuItem1);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem2);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem3);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem4);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem5);
		authorizationGroup.setAuthorizationGroupMenuItems(authorizationGroupMenuItems);

		authorizationGroupDAO.save(authorizationGroup);
	}

	private void injectAuthorizationUser() {
		MenuItem menuItem1 = new MenuItem("Web", MenuItemType.SECTION.getValue());
		MenuItem menuItem2 = new MenuItem("Home", MenuItemType.WEBVIEW.getValue());
		// MenuItem menuItem3 = new MenuItem("Facebook",
		// MenuItemType.WEBVIEW.getValue());
		MenuItem menuItem4 = new MenuItem("App", MenuItemType.SECTION.getValue());
		MenuItem menuItem5 = new MenuItem("Pinterest app", MenuItemType.INTENT.getValue());

		menuItem2.setIconPath("https://s6.postimg.org/6p83pcrch/alarm_clock.png");
		menuItem5.setIconPath("https://s6.postimg.org/iiai7bd69/garbage_2.png");

		// 1 is section, no need to set param
		// 4 is section, no need to set param
		MenuItemParameter menuItemParameter2 = new MenuItemParameter();
		// MenuItemParameter menuItemParameter3 = new MenuItemParameter();
		MenuItemParameter menuItemParameter5 = new MenuItemParameter();
		List<MenuItemParameter> parametersMenuItem2 = new ArrayList<>();
		// List<MenuItemParameter> parametersMenuItem3 = new ArrayList<>();
		List<MenuItemParameter> parametersMenuItem5 = new ArrayList<>();

		parametersMenuItem2.add(menuItemParameter2);
		menuItem2.setParameters(parametersMenuItem2);
		menuItemParameter2.setValue("http://www.tawabocah.com");
		menuItemParameter2.setMenuItem(menuItem2);

		// parametersMenuItem3.add(menuItemParameter3);
		// menuItem3.setParameters(parametersMenuItem3);
		// menuItemParameter3.setValue("http://facebook.com");
		// menuItemParameter3.setMenuItem(menuItem3);

		parametersMenuItem5.add(menuItemParameter5);
		menuItem5.setParameters(parametersMenuItem5);
		menuItemParameter5.setValue("com.pinterest");
		menuItemParameter5.setMenuItem(menuItem5);

		AuthorizationGroup authorizationGroup = new AuthorizationGroup("User");
		Set<MenuItem> authorizedMenuItems = new HashSet<>();
		authorizedMenuItems.add(menuItem1);
		authorizedMenuItems.add(menuItem2);
		// authorizedMenuItems.add(menuItem3);
		authorizedMenuItems.add(menuItem4);
		authorizedMenuItems.add(menuItem5);

		AuthorizationGroupMenuItem authorizationGroupMenuItem1 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem1.setMenuItem(menuItem1);
		authorizationGroupMenuItem1.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem1.setItemSequence(10);

		AuthorizationGroupMenuItem authorizationGroupMenuItem2 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem2.setMenuItem(menuItem2);
		authorizationGroupMenuItem2.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem2.setItemSequence(20);

		// AuthorizationGroupMenuItem authorizationGroupMenuItem3 = new
		// AuthorizationGroupMenuItem();
		// authorizationGroupMenuItem3.setMenuItem(menuItem3);
		// authorizationGroupMenuItem3.setAuthorizationGroup(authorizationGroup);
		// authorizationGroupMenuItem3.setItemSequence(30);

		AuthorizationGroupMenuItem authorizationGroupMenuItem4 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem4.setMenuItem(menuItem4);
		authorizationGroupMenuItem4.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem4.setItemSequence(40);

		AuthorizationGroupMenuItem authorizationGroupMenuItem5 = new AuthorizationGroupMenuItem();
		authorizationGroupMenuItem5.setMenuItem(menuItem5);
		authorizationGroupMenuItem5.setAuthorizationGroup(authorizationGroup);
		authorizationGroupMenuItem5.setItemSequence(50);

		Set<AuthorizationGroupMenuItem> authorizationGroupMenuItems = new TreeSet<>();
		authorizationGroupMenuItems.add(authorizationGroupMenuItem1);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem2);
		// authorizationGroupMenuItems.add(authorizationGroupMenuItem3);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem4);
		authorizationGroupMenuItems.add(authorizationGroupMenuItem5);
		authorizationGroup.setAuthorizationGroupMenuItems(authorizationGroupMenuItems);

		authorizationGroupDAO.save(authorizationGroup);
	}

	private void injectUsers() {
		UserAccount admin = new UserAccount("admin", cryptoService.encrypt("password"), "Admin");
		UserAccount userAccount = new UserAccount("user", cryptoService.encrypt("password"), "User");

		List<UserAccount> userAccounts = new ArrayList<>();
		userAccounts.add(admin);
		userAccounts.add(userAccount);

		userAccountDAO.save(userAccounts);
	}

	@Override
	public void run(String... arg0) throws Exception {
		injectAuthorizationAdmin();
		injectAuthorizationUser();

		injectUsers();
	}

}
