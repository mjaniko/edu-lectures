package com.digitaledu.repository;


import com.digitaledu.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    // SELECT * FROM user WHERE username = ? LIMIT 1
    Users findByUsername(String username);

    // SELECT * FROM user WHERE username = ? and active = ? LIMIT 1
    Users findByUsernameAndActive(String username, boolean active);


    // SELECT * FROM user WHERE active = ?
    List<Users> findByActive(boolean active);

    @Query("FROM Users u where u.username = ?1 ")
    Users getUserName(String username);

    @Query(value = "SELECT id FROM t_user where username = :parameter LIMIT 1", nativeQuery = true)
    Long getUserNamee(@Param("parameter") String username);

    /**
     * @param active
     * @Transactional ამ ანოტაციის მიზანია სანამ კონკრეტული ოპერაცია სრულდება,
     * მასზე სხვა გარე მოთხოვნა ვერ განხორციელდება რადგან
     * ამ დროს მონაცემთა ბაზის ცხრილი Locked- სთეითშია
     * @Modifying როდესაც ჩვენ რაიმე სახის რედაქტირების ოპერაციას ვასრულებთ მონაცემთა ბაზაზე ჩვენ სპრინგს
     * უნდა შევატყობინოთ რომ ეს ოპერაცია არის რედაქტირებისთვის გამიზუნლი
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying(flushAutomatically = true) // ეუბნება ჩვენს რეპოზიტორის მონაცემთა ბაზაში უნდა შეცვალოს მნიშვნელობები
    @Query("UPDATE Users u set u.active = :parameter")
    void setAllUserActivityStatus(@Param("parameter") boolean active);

}
