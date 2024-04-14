package org.aku.freello.repositories;

import org.aku.freello.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Modifying
    @Query("update User u set u.name = :name where u.id = :id")
    void updateName(@Param(value = "id") UUID id, @Param(value = "name") String name);

    @Modifying
    @Query("update User SET password = :password where id = :id")
    void updatePassword(@Param(value = "id") UUID id, @Param(value = "password") String password);

}
