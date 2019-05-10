package com.digitaledu.controller;

import com.digitaledu.data.dto.ResponseDTO;
import com.digitaledu.data.specification.GenericSpecification;
import com.digitaledu.model.DeviceState;
import com.digitaledu.model.Users;
import com.digitaledu.repository.DeviceStateRepository;
import com.digitaledu.wrapper.LecturerWrapper;
import com.digitaledu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private DeviceStateRepository deviceStateRepository;

    @GetMapping
    public List<LecturerWrapper> call() {
        return lectureService.lecturerDTOList();
    }

    @GetMapping("/getAllDevice/{from}/{to}")
    public ResponseEntity getAllDevice(@PathVariable String from, @PathVariable String to){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date fromDate;
        Date toDate;
        try {
            fromDate = format.parse(from);
            toDate = format.parse(to);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.ok(
                    ResponseDTO.builder()
                            .success(false)
                            .content("Parse Exceptio")
                            .build()
            );
        }

        List<DeviceState> user = deviceStateRepository.findAll(GenericSpecification.filterRangeByDate(fromDate, toDate));
        if (!user.isEmpty()) {
            return ResponseEntity.ok(
                    ResponseDTO.builder()
                            .success(true)
                            .content(user)
                            .build()
            );
        }
        return ResponseEntity.ok(
                ResponseDTO.builder()
                        .success(false)
                        .content("Device is null")
                        .build()
        );
    }

}
