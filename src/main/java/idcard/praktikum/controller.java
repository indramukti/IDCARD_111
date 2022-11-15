/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idcard.praktikum;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */

@Controller
public class controller {
    @ResponseBody
    @RequestMapping ("/getData")
    public String getData (@RequestParam("text") String text,
                             @RequestParam("date")@DateTimeFormat (pattern = "yyyy-MM-dd")Date date,
                             @RequestParam("image")MultipartFile file)
                             throws IOException, ParseException{
            
            SimpleDateFormat tanggal = new SimpleDateFormat ("dd/MM/yyyy");
            String newTanggal =tanggal.format(date);
            
    
    String blob = Base64.encodeBase64String(file.getBytes());
    
    return "Name    :" + text +
           "<br> Born   :" + newTanggal +
           "<br> photo : <img width=100 src='data:image/jpeg;base64, "+blob+" '/></img><br>";
    
    }
    
    
}
