package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookStorage storage;

    @RequestMapping("/book")
    public String BookDelete(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        if (id > 0) {
            storage.removeByName(id);
        }
        model.addAttribute("div", storage.isEmpty());
        model.addAttribute("books", storage.get());
        return "book";
    }

    @GetMapping("/book/add")
    public String BookAdd(Model model) {
        model.addAttribute("book", new NewBook("","",""));
        return "add";
    }

    @PostMapping("/book/add")
    public String BookAdd(@ModelAttribute NewBook books, Model model) {
        model.addAttribute("book", books);
        if (!((books.getName().equals("")) && (books.getAuthor().equals("")) && (books.getSize().equals("")))) {
            storage.add(books.getName(), books.getAuthor(), books.getSize());
            model.addAttribute("div", storage.isEmpty());
            model.addAttribute("books", storage.get());
            return "book";
        }
        return "add";
    }
}