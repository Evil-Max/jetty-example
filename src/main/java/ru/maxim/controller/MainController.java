package ru.maxim.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.maxim.receiver.MessageReceiver;
import ru.maxim.sender.MessageSender;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class MainController {

    @Autowired
    private MessageReceiver receiver;

    @Autowired
    private MessageSender sender;


    @GetMapping("/")
    public String index(ModelMap model)  {
        model.addAttribute("test","Введи сообщение:");
        return "index";
    }


    @ResponseBody
    //@PostMapping(value="/service", produces = "charset=UTF-8")
    @RequestMapping(method = POST,value = "/service",produces = "text/plain;charset=UTF-8")
    public String service(
            @RequestParam(value = "mode",required = true) String mode,
            @RequestParam(value = "message",required = false) String message,
            ModelMap model
    ) {
        String response="";
        switch (mode) {
            case "send":
                if (message!=null) {
                    sender.send(message);
                    response=message;
                }
                break;
            case "receive":
                response = receiver.receive();
                break;
            default:
                break;
        }
        return response;
    }

    @PostMapping("/send")
    public String send(
            ModelMap model,
            @RequestParam("message") String send_message
    )  {

        sender.send(send_message);

        String receive_message = receiver.receive();

        model.addAttribute("send_message", send_message);
        model.addAttribute("receive_message", receive_message);
        return "result";
    }

}