package com.BankingApplication.Service;

import com.BankingApplication.Entity.User;
import com.BankingApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {
    @Autowired
    UserRepository UsRepo;
    public ResponseEntity<User> saveUser(User us) {
        try{
            User a=UsRepo.save(us);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<User> getUserById(int id) {
        Optional<User> lst=UsRepo.findById(id);
        if(!lst.isEmpty())
        {
            return new ResponseEntity<>(lst.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<User> updateByUserId(int id,User us) {
        Optional<User> lst=UsRepo.findById(id);
        if(!lst.isEmpty())
        {
            User u=lst.get();
            u.setEmail(us.getEmail());
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
