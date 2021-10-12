package com.codingdojo.crude.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.crude.models.Book;
import com.codingdojo.crude.models.LoginUser;
import com.codingdojo.crude.models.User;
import com.codingdojo.crude.services.BookService;
import com.codingdojo.crude.services.UserService;

@Controller
public class HomeController {
	
	
	private UserService userServ;
	
	private BookService bookServ;
	
	
	
	
	
	
	public HomeController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	//Login and Reg Landing Page
	
        @RequestMapping("/")
        public String index(Model model) {
        	model.addAttribute("newUser", new User());
          	model.addAttribute("newLogin", new LoginUser());
        	return "index.jsp";
        }

        
       //Registration Action 
        
        @PostMapping("/register")
        public String register(@Valid @ModelAttribute("newUser") User newUser,
        		BindingResult result, Model model, HttpSession session) {
        	userServ.register(newUser, result);
        	
        	if(result.hasErrors()) {
        		model.addAttribute("newLogin", new LoginUser());
        		return "index.jsp";
        	}
        	
        	session.setAttribute("user-id", newUser.getId());
        		return "redirect:/";        	
        	
        }
        
 
        
        //Login Action
        @PostMapping("/login")
        public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
                BindingResult result, Model model, HttpSession session) {
            
        	
        	User user = userServ.login(newLogin, result);
            if(result.hasErrors()) {
                model.addAttribute("newUser", new User());
                return "index.jsp";
            }
            session.setAttribute("user_id", user.getId());
            return "redirect:/dashboard";
        }
        
        
        //Dashboard for all books
        @RequestMapping("/dashboard")
        public String dashboard(Model model, HttpSession session) {
        	
        	model.addAttribute("allBooks", bookServ.allBooks());
        	model.addAttribute("user", userServ.oneUser((Long) 
        			session.getAttribute("user_id")));
        
        	return "dashboard.jsp";
        }
        
        
        
        
        //New book render JSP
        @RequestMapping("/newBook")
        public String newBook(@ModelAttribute("book")Book book,Model model , HttpSession session) {
        	
        	
        	Long user_id = (Long)session.getAttribute("user_id");
        	
        	
        	model.addAttribute("user", user_id);
        	
        
        	return "newBook.jsp";
        	
        }
        
        
        
        //creating new book action
        @RequestMapping(value="/makeBook", method=RequestMethod.POST)
        public String CreatedBy(@Valid @ModelAttribute("book") Book book, 
        		BindingResult result) {
        	if(result.hasErrors()) {
        		return "newBook.jsp";
        	} else {
        		bookServ.create(book);
        		return "redirect:/dashboard";
        	}
        	
        	
        }
           
        
        //Edit book render JSP
        
        @RequestMapping("/editBook/{id}") 
        	public String editCar(@PathVariable("id") Long id, 
        			@ModelAttribute("book") Book book, 
        			Model model, HttpSession session) {
        	Book oneBook = bookServ.oneBook(id);
        	model.addAttribute("book", oneBook);
        	
           Long user_id = (Long)session.getAttribute("user_id");
        	
        	model.addAttribute("user", user_id);
        	
        		return "editBook.jsp";
        	}
        
        
        //editing Book Action
        
        
        @RequestMapping(value="/editingBook/{id}", method=RequestMethod.PUT)
        public String editingBook(@Valid @ModelAttribute("book") Book book, 
        	 BindingResult result, Model model){
        	if(result.hasErrors()) {
        		
        		return "editBook.jsp";
        	} else {
        		bookServ.update(book);
        		return "redirect:/dashboard";
        	}
        	
        } 
        	
      
        
        
         //Render One book Jsp
        
        @RequestMapping("/oneBook/{id}") 
        public String oneBook(@PathVariable("id") Long id,
        		Model model,
        		HttpSession session) {
        	User user = userServ.oneUser((Long) session.getAttribute("user_id"));
        	
        	model.addAttribute("user", user);
        	model.addAttribute("book", bookServ.oneBook(id));
        	return "oneBook.jsp";
        }
        
        @RequestMapping("/logout")
        public String logout(HttpSession session) {
        	session.invalidate();
        	return "redirect:/";
        	
        }
        
        
        //deleting a book
        @RequestMapping("/destroy/{id}")
        public String Destroyable(@PathVariable("id") Long id) {
        	bookServ.destroy(id);
        	return "redirect:/dashboard";
        }
        
        
        
}




