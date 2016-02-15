package park.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import park.app.dto.ServiceResponse;
import park.app.dto.UserItemRequest;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/resource1/perro")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping(value = {"/resource2/perro"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public ServiceResponse searchPublicItems(
			@RequestParam(value = "latitude", required = false) Double latitude,
			@RequestParam(value = "longitude", required = false) Double longitude,
			@RequestParam(value = "radius", required = false) Integer radius,
			@RequestParam(value = "q", required = false) String criteria,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "priceFrom", required = false) Double priceFrom,
			@RequestParam(value = "priceTo", required = false) Double priceTo,
			@RequestParam(value = "categoryId", required = false) Long categoryId,
			@RequestParam(value = "groupId", required = false) Long groupId,
			@RequestParam(value = "publisherName", required = false) String publisherName,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "requestTime", required = false) String requestTime) {
        return new ServiceResponse();
    }

    
    @RequestMapping(value = {"/resource2/perro/{id}"}, method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public ServiceResponse removeItem(@PathVariable Long id) {
		UserItemRequest request = new UserItemRequest();
		request.setItemId(id);
		try {
			return new ServiceResponse();
		} catch (Throwable t) {
			throw new RuntimeException();
		}
	}
    
    @RequestMapping(value = {"/resource3/perro/{id}"}, method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public ServiceResponse removeItem2(@PathVariable Long id) {
		UserItemRequest request = new UserItemRequest();
		request.setItemId(id);
		try {
			return new ServiceResponse();
		} catch (Throwable t) {
			throw new RuntimeException();
		}
	}
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
