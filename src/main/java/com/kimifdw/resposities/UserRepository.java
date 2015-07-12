package com.kimifdw.resposities;

import com.kimifdw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimiyu on 15/7/12.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByLoginName(String loginName);
}
