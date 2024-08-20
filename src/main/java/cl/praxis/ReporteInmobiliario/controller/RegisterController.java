package cl.praxis.ReporteInmobiliario.controller;

import cl.praxis.ReporteInmobiliario.model.entities.User;
import cl.praxis.ReporteInmobiliario.model.service.FileStorageService;
import cl.praxis.ReporteInmobiliario.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService uService;
    private final FileStorageService fileStorageService;
    public RegisterController(UserService uService, FileStorageService fileStorageService) {
        this.uService = uService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping
    public String getCreateUser(){
        return "register";
    }

    @PostMapping
    public String postCreateUser(@ModelAttribute User user/*,
                                 @RequestParam("image")MultipartFile imageFile*/){
       /* if(!imageFile.isEmpty()) {
            String image = fileStorageService.storeFile(imageFile);
            user.setImage(image);
        }*/
      boolean result = uService.create(user);
      return "redirect:/";
    }
}
