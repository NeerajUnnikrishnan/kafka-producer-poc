package com.stackroute.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import com.stackroute.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

  //  @Value("${app.topic.foo}")
    private static final String TOPIC = "kafkajsontest";

//    @GetMapping("/publish/{message}")
//    public String post(@PathVariable("message") final String message) {
//
//        kafkaTemplate.send(TOPIC, message);
//
//        return "Published successfully";
//    }
//
//    @GetMapping("/publishJson")
//    public String publishJson() {
//        User user = new User(1,"root");
//        kafkaTemplate.send(TOPIC,user);
//
//        return "Published JSON successfully";
//    }


    @PostMapping("/postjson/user")
    public ResponseEntity<?> postJson(@RequestBody User user) {
        kafkaTemplate.send(TOPIC,user);
        ResponseEntity responseEntity;

        responseEntity=new ResponseEntity<User>(user, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/getjson")
    public ResponseEntity<String> getJSon() {
        ResponseEntity responseEntity=new ResponseEntity<String>("Dfsdf", HttpStatus.OK);
        return responseEntity;
    }
}