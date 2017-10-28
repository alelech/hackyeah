package pl.hackyeah.hackyeah.controlles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET, produces = "application/json")
    String test() {
        return "{\"id\":1,\"content\":\"Hello, Blotter!\"}";
    }
}
