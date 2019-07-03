package Hello.Welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;


    public HelloServlet(HelloService service) {
        this.service = service;
    }

    @GetMapping("/api")
    String prepareGreeting() {
        return prepareGreeting(null, null);
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    String prepareGreeting(@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Request got.");
        return service.prepareGreetingById(name, langId);
    }
}
