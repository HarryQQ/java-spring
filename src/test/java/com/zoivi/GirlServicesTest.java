package com.zoivi;

import com.zoivi.domain.Girl;
import com.zoivi.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/5/1 0001.
 */
@RunWith(SpringRunner.class) // 表示要在测试环境运行，底层是junit
@SpringBootTest // 启动整个spring工程
public class GirlServicesTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(35);
        System.out.println(girl.toString());
        // 断言 在进度条后面可以直观看到测试有没有通过
        Assert.assertEquals(new Integer(22), girl.getAge());
    }
}
