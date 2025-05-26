package com.learning.RailwayCrud.service;

import com.learning.RailwayCrud.dto.TrainsDTO;
import com.learning.RailwayCrud.dto.UsersDTO;
import com.learning.RailwayCrud.entity.Trains;
import com.learning.RailwayCrud.entity.Users;

import java.util.List;

public interface UserServices {
    List<UsersDTO> getAllUsers();

    UsersDTO saveUser(Users user);

    UsersDTO getUserById(Long id);

    UsersDTO updateUser(Users user);

    void deleteUser(Users user);
}
