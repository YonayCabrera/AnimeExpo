package org.anime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/*")
    public String index() {
        return "index";
    }

    /*@GetMapping(path = "/403")
    public void accessDenied(HttpServletResponse response){
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.error(e.getMessage(), e);
        }
    }*/

}
