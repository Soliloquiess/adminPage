/*
CREATE TABLE IF NOT EXISTS `study`.`settlement` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `price` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;



alter table `study`.`settlement` add sum_price varchar(100) not null default '0';
 */

package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.request.OrderGroupApiRequest;
import com.example.study.model.network.Header;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.service.OrderGroupApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
@RequiredArgsConstructor
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private final OrderGroupApiLogicService orderGroupApiLogicService;


    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderGroupApiLogicService.delete(id);
    }

    @Override
    public Header<OrderGroupApiResponse> sum(@PathVariable Long id){
        return orderGroupApiLogicService.sum(id);
    }
}
