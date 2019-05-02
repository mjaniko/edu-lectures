package com.digitaledu.tasks;

import com.digitaledu.model.Users;
import com.digitaledu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UserTask {


    @Autowired
    private UsersRepository usersRepository;

    // * "0 0 * * * *" = the top of every hour of every day.
    // * "*/10 * * * * *" = every ten seconds.
    // * "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
    // * "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
    // * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
    // * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
    // * "0 0 0 25 12 ?" = every Christmas Day at midnight

    // http://www.cronmaker.com/
    //@Scheduled(cron = "0 0/2 * 1/1 * *")
    public void manageUser() {
        System.out.println("Current time" + new Date());
        System.out.println("STARTED TASK");
        // წამოიღე სერვერიდან ყველა მომხამარებელი
        List<Users> usersList = usersRepository.findAll();
        // დაბეჭდე რაოდენობა
        int count = usersList.size();
        System.out.println(count);
        // ამის შემდეგ დაბეჭდე username
        usersList.forEach((element) -> {
            System.out.println(element.getUsername());
        });
        System.out.println("FINISHED TASK");
    }


    //@Scheduled(fixedDelay = 1000L)
    public void runEverySecond() {
        System.out.println("Running At:" + new Date());
    }

    //@Scheduled(fixedDelayString = "1000")
    public void runEverySecond2() {
        System.out.println("Running At2:" + new Date());
    }

}
