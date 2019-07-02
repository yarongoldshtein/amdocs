package com.example.amdocs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/getOrders")
    public List<Data> getOrders() {
        DataMock dataMock = new DataMock();
        return dataMock.getAllOrders();
    }

    @GetMapping("/getOrders/{orderId}")
    public Data getOrders(@PathVariable(value = "orderId") String orderId) throws Exception {
        DataMock dataMock = new DataMock();
        List<Data> allOrders = dataMock.getAllOrders();
        Optional<Data> optionalData = allOrders.stream().filter(data -> String.valueOf(data.getId()).equals(orderId)).findFirst();
        if (optionalData.isPresent()) {
            return optionalData.get();
        }
        throw new Exception("Data Not Found!");
    }

    @GetMapping("/getOrders/{sortBy}/{order}")
    public List<Data> getOrders(@PathVariable(value = "sortBy") String sortBy, @PathVariable(value = "order") String order) throws Exception {
        DataMock dataMock = new DataMock();
        List<Data> allOrders = dataMock.getAllOrders();
        switch (sortBy) {
            case "date":
                allOrders.sort(Comparator.comparing(Data::getOrder_date));
                break;
            case "price":
                allOrders.sort(Comparator.comparing(Data::getPrice));
                break;
            case "first_name":
                allOrders.sort(Comparator.comparing(Data::getFirst_name));
                break;
            default:
                allOrders.sort(Comparator.comparing(Data::getId));
        }
        if (order.equals("desc")) {
            Collections.reverse(allOrders);
        } else if (!order.equals("asc")) {
            throw new Exception("Illegal order");
        }
        return allOrders;
    }

    @PostMapping("/login")
    public ResponseEntity<Login> createQuote(@Valid @RequestBody Login login) throws Exception {
        String[] email = login.getEmail().split("@");
        if (email.length != 2 || !email[1].contains(".")) {
            throw new Exception("Illegal email");
        }
        String password = login.getPassword();
        if (password.length() > 7) {
            char ch;
            boolean capitalFlag = false;
            boolean lowerCaseFlag = false;
            boolean numberFlag = false;
            boolean specialFlag = false;
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(password);
            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isDigit(ch) && !numberFlag) {
                    numberFlag = true;
                } else if (Character.isUpperCase(ch) && !capitalFlag) {
                    capitalFlag = true;
                } else if (Character.isLowerCase(ch) && !lowerCaseFlag) {
                    lowerCaseFlag = true;
                } else if (m.find()) {
                    specialFlag = true;
                }
            }
            if (numberFlag && capitalFlag && lowerCaseFlag && specialFlag) {
                return ResponseEntity.ok().body(login);
            } else {
                throw new Exception("Illegal password");
            }
        } else {
            throw new Exception("Illegal password - too short");
        }
    }
}
