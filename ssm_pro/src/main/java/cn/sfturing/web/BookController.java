package cn.sfturing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.Book;
import cn.sfturing.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	private String detail( Model model) {
		
		Book book = bookService.getById(1000);
		
		model.addAttribute("book", book);
		return "detail";
	}

}
