package pl.hackyeah.hackyeah.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "hello blotter";
    }
}
