package com.BankingApplication.Controller;

import com.BankingApplication.Dto.AccountDto;
import com.BankingApplication.Entity.Account;
import com.BankingApplication.Entity.User;
import com.BankingApplication.Repository.AccountRepository;
import com.BankingApplication.Repository.UserRepository;
import com.BankingApplication.Service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class AccountManagement {
    @Autowired
    AccountManagementService ams;

    @PostMapping("/add_account")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto ac)
    {
       return ams.saveAccount(ac);
    }

    @GetMapping("/get_account_details")
    public ResponseEntity<List<Account>> getAccountDetails()
    {

        return ams.getAccountDetails();
    }
    @GetMapping("/get_account_details_by_Id/{id}")
    public ResponseEntity<Account> getAccountDetailsById(@PathVariable int id)
    {
        return ams.getAccountDetailsById(id);
    }

    @DeleteMapping("/delete_by_Id/{id}")
    public ResponseEntity<Account> deleteById(@PathVariable int id)
    {
        return ams.deleteById(id);
    }



}
