package org.laicose.supplyflow;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstClass {

    @GetMapping("/home")
    public String getFrirst(){
        return "Hello zakaria";
    }
}
