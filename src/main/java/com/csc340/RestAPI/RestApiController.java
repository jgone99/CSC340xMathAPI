package com.csc340.RestAPI;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sentini
 */
@RestController
public class RestApiController {
    
    @GetMapping("/math")
    public Object getAsteroidData(@RequestParam(value = "operation", defaultValue = "random") String op) {
        String url = "https://x-math.herokuapp.com/api/" + op;
        RestTemplate restTemplate = new RestTemplate();
        Object jSonMath = restTemplate.getForObject(url, Object.class);
        
        String mathExp = restTemplate.getForObject(url, String.class);
        JSONObject jo = new JSONObject(mathExp);
        System.out.println(jo.toString());
        
        return jSonMath;
    }

}
