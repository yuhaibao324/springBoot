package org.shenlan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shenlan.async.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by wangwei on 2016/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

	@Autowired
	private Task task;

	@Test
	public void test() throws Exception {
		long start = System.currentTimeMillis();

		while (true) {
			Future<String> task1 = task.doTaskOne();
			Future<String> task2 = task.doTaskTwo();
			Future<String> task3 = task.doTaskThree();
			Future<String> task4 = task.doTaskFour();

			while (true) {
				if (task4.isDone() && task1.isDone() && task2.isDone() && task3.isDone()) {
					// 三个任务都调用完成，退出循环等待
					break;
				}
				Thread.sleep(1000);
			}

			long end = System.currentTimeMillis();

			System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
			Thread.sleep(3000);
		}
	}
}
