package com.learning.RailwayCrud.service.implementation;

import com.learning.RailwayCrud.dto.BookingDTO;
import com.learning.RailwayCrud.dto.UsersDTO;
import com.learning.RailwayCrud.entity.Booking;
import com.learning.RailwayCrud.entity.Users;
import com.learning.RailwayCrud.repository.UsersRepository;
import com.learning.RailwayCrud.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UsersRepository usersRepository;

    private UsersDTO mapUsertoDTO(Users user){
        UsersDTO userdto = new UsersDTO();
        userdto.setUserID(user.getUserID());
        userdto.setMobile_No(user.getMobile_No());
        userdto.setUser_name(user.getUser_name());
        userdto.setEmail_address(user.getEmail_address());
        userdto.setPassword(user.getPassword());
        return userdto;
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> Userlist = usersRepository.findAll();
        List<UsersDTO> users = new ArrayList<>();

        for(Users user : Userlist){
            users.add(mapUsertoDTO(user));
        }
        return users;
    }

    @Override
    public UsersDTO saveUser(Users user) {
        Users SavedUser = usersRepository.save(user);
        return this.mapUsertoDTO(SavedUser);
    }

    @Override
    public UsersDTO getUserById(Long id) {
        Optional<Users> userOptional = usersRepository.findById(id);
        if(userOptional.isPresent()) {
            return this.mapUsertoDTO(userOptional.get());
        } else
            return null;
    }

    @Override
    public UsersDTO updateUser(Users user) {
        Users UpdatedUser = usersRepository.save(user);
        return this.mapUsertoDTO(UpdatedUser);
    }

    @Override
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }
}
