//package net.shopin.job;
//
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * <p>ClassName:TestSerialJob</p>
// * <p>Description:	</p>
// * <p>Company: www.shopin.net</p>
// *
// * @author zhangyong@shopin.cn
// * @version 1.0
// * @date 2018/4/10 10:28
// */
//@Component
//@EnableScheduling
//@PropertySource(value = "classpath:/application.properties")
//public class TestSerialJob {
//
//    @Scheduled(cron = "${time}")
//    public void test2() {
//        System.out.println("串行time每5s执行一次,当前时间为" + System.currentTimeMillis());
//    }
//
//}
