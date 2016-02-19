package com.example.helloworld.app.echo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("echo")
public class EchoController {

	/**
	 * このアノテーションがついたメソッドの返り値は、自動でModelに追加される。<br/>
	 * Modelの属性名を、 @ModelAttribute で指定することもできるが<br/>
	 * デフォルトでは、クラス名の先頭を小文字にした値が、属性名になる。<br/>
	 * この場合は、”echoForm”である。フォームの属性名は、form:form
	 * タグのmodelAttribute属性の値に一致している必要がある。
	 */
	@ModelAttribute
	public EchoForm setUpEchoForm() {
		EchoForm form = new EchoForm();
		return form;
	}

	/**
	 * メソッドに付加した @RequestMapping アノテーションの value 属性に、<br/>
	 * 何も指定しない場合、クラスに付加した @RequestMapping のルートに、マッピングされる。<br/>
	 * この場合、”<contextPath>/echo”にアクセスすると、 index メソッドが呼ばれる。<br/>
	 * method 属性に何もしない場合は、任意のHTTPメソッドでマッピングされる。
	 */
	@RequestMapping
	public String index(Model model) {
		// View名で”echo/index”を返すので、ViewResolverにより、
		// “WEB-INF/views/echo/index.jsp”がレンダリングされる。
		return "echo/index";
	}

	/**
	 * メソッドに付加した @RequestMapping アノテーションのvalue属性に”hello”を、<br/>
	 * method属性にRequestMethod.POSTを指定しているので、<br/>
	 * この場合、”<contextPath>/echo/hello”にPOSTメソッドを使用してアクセスすると hello メソッドが呼ばれる。
	 */
	@RequestMapping(value = "hello", method = RequestMethod.POST)
	// 引数に、EchoFormにはModelに追加されたEchoFormオブジェクトが渡される。
	// Validation対象の引数に @Validated アノテーションを付加し、 BindingResult オブジェクトを引数に追加
	public String hello(@Validated EchoForm form, BindingResult result, Model model) {
		// 入力エラーがある場合は、入力画面を表示するためのView名を返却する。
		if (result.hasErrors()) {
			return "echo/index";
		}
		// フォームで入力された name を、Viewにそのまま渡す。
		model.addAttribute("name", form.getName());
		return "echo/hello";
	}
}