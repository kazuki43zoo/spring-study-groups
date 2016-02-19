package com.example.helloworld.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 
 * @Controller アノテーションを付けることで、DIコンテナにより、コントローラクラスが自動で読み込まれる。 前述「Spring
 *             MVCの設定ファイルの説明(2)」の設定により、component-scanの対象となっている。
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * HTTPメソッドがGETまたはPOSTで、Resource（もしくはRequest URL）が”/”で、アクセスする際に実行される。
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		/**
		 * Viewに渡したいオブジェクトをModelに設定する。
		 */
		model.addAttribute("serverTime", formattedDate);
		/**
		 * View名を返却する。前述「Spring
		 * MVCの設定ファイルの説明(3)」の設定により、”WEB-INF/views/welcome/home.jsp”がレンダリングされる。
		 */
		return "welcome/home";
	}

}
