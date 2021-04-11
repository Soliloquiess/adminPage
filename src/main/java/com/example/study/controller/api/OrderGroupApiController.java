/*
CREATE TABLE IF NOT EXISTS `study`.`settlement` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `price` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;



alter table `study`.`settlement` add sum_price varchar(100) not null default '0';
 */

/*
테이블은 만들었으나 api하는 점에서 잘 모르겠어서 나중에 멘토님께서 만드신 모범 답안이나 타 동기생들의 좋은 코드같은거 올려주시면 감사하겠습니다..
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
