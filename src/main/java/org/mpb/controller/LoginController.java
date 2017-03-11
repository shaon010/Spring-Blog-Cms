package org.mpb.controller;

import org.mpb.base.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends ControllerBase {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
