package com.endpointupdateuser.Service;

import com.endpointupdateuser.Entity.UserEntity;
import com.endpointupdateuser.UserDto.UserDto;
import com.endpointupdateuser.UserRepository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public Object postUser(UserDto user){
        UserEntity newUser = new UserEntity();
        BeanUtils.copyProperties(user, newUser);
        userRepository.save(newUser);
        return userRepository.findById(newUser.getId());
    }

    public String updateUser(UserEntity user){
        UserEntity updatedUser = userRepository.findById(user.getId()).get();
        UserEntity userEmail = userRepository.findByEmail(user.getEmail());
        try {
            if(userEmail != null){
                if(!userEmail.getId().equals(user.getId())) {
                    return "Email já cadastrado!";
                }
            }

            updatedUser.setNome(user.getNome());
            updatedUser.setEmail(user.getEmail());
            userRepository.save(updatedUser);
            return "Usuário alterado com sucesso!";
        }catch (Exception e){
            System.out.println("AAA" + e.getMessage() + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            return e.getMessage();
        }

    }
}
