package com.example.helloworld.app.echo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * データをサーバに保存する場合(更新系の処理の場合)は、POSTメソッド。
 * データをサーバに保存しない場合(参照系の処理の場合)は、GETメソッド又は未指定(任意のメソッド)。
 *
 */

@Controller
@RequestMapping("echo")
public class EchoController {

	/**
	 * このアノテーションがついたメソッドの返り値は、自動でModelに追加される。<br/>
	 * Modelの属性名を @ModelAttribute で指定することもできるが、デフォルトでは、クラス名の先頭を小文字にした値が、属性名になる。
	 * <br/>
	 * この場合は”echoForm”。フォームの属性名は、次に説明する form:form タグ の modelAttribute
	 * 属性の値に一致している必要がある。
	 */
	@ModelAttribute
	public EchoForm setUpEchoForm() {
		EchoForm form = new EchoForm();
		return form;
	}

	/**
	 * メソッドに付加した @RequestMapping アノテーションのvalue属性に、何も指定しない場合、<br/>
	 * クラスに付加した @RequestMapping のルートに、マッピングされる。<br/>
	 * この場合、”<contextPath>/echo”にアクセスすると、 index メソッドが呼ばれる。 method
	 * 属性に何もしない場合は、任意のHTTPメソッドでマッピングされる。
	 */
	@RequestMapping
	public String index(Model model) {
		/**
		 * View名で”echo/index”を返すので、ViewResolverにより、<br/>
		 * “WEB-INF/views/echo/index.jsp”がレンダリングされる。
		 */
		return "echo/index";
	}

	/**
	 * @RequestMapping アノテーションのvalue属性に”hello”を、method属性にRequestMethod.
	 *                 POSTを指定しているので、<br/>
	 *                 ”<contextPath>/echo/hello”にPOSTメソッドを使用してアクセスすると hello
	 *                 メソッドが呼ばれる。
	 */
	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String hello(EchoForm form, Model model) {
		model.addAttribute("name", form.getName());
		return "echo/hello";
	}
}