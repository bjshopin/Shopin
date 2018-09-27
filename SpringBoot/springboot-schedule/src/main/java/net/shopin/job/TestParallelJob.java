package net.shopin.job;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>ClassName:TestParallelJob</p>
 * <p>Description: 测试Job	</p>
 * <p>Company: www.shopin.net</p>
 *
 * @author zhangyong@shopin.cn
 * @version 1.0
 * @date 2018/4/10 10:33
 */
@Component
@EnableScheduling
@PropertySource(value = "classpath:/application.properties")
@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.HIGHEST_PRECEDENCE
)
public class TestParallelJob {

    @Scheduled(cron = "${TestParallelJob}")
    @Async
    public void test2() {
        System.out.println("并行JOB-2-现在的时间是: 每2s执行一次" + System.currentTimeMillis());
    }
}
